package com.gdg.boss.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.boss.util.Resources
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : UIState, A : BaseSideEffect, I : BaseIntent, E : BaseEvent>(
    initialState: S,
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _effect: Channel<A> = Channel()
    val effect = _effect.receiveAsFlow()

    private val _intent: MutableSharedFlow<I> = MutableSharedFlow()
    private val intent = _intent.asSharedFlow()

    private val _event: MutableSharedFlow<E> = MutableSharedFlow()
    private val event = _event.asSharedFlow()

    init {
        viewModelScope.launch {
            intent.collect { intent ->
                try {
                    handleIntent(intent)
                } catch (e: Exception) {
                    handleError(e)
                }
            }
        }

        viewModelScope.launch {
            event.collect { event ->
                handleEvent(event)
            }
        }
    }

    protected val currentState: S
        get() = _uiState.value

    open fun setIntent(intent: I) {
        viewModelScope.launch {
            _intent.emit(intent)
        }
    }

    open fun setEvent(event: E) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    protected abstract fun handleIntent(intent: I)

    protected abstract fun handleEvent(event: E)

    protected fun setToastEffect(message: String) {
        viewModelScope.launch {
            setEffect(BaseSideEffect.ShowToast(message) as A)
        }
    }
    protected open fun handleError(exception: Exception) {
        viewModelScope.launch {

        }
    }

    protected fun setState(reduce: S.() -> S) {
        val state = currentState.reduce()
        _uiState.value = state
    }

    protected fun setEffect(vararg builders: A) {
        for (effect in builders) {
            viewModelScope.launch { _effect.send(effect) }
        }
    }

    protected suspend fun <T> Flow<Resources<T>>.collectWithCallback(
        onSuccess: suspend (T) -> Unit,
        onFailed: suspend (Throwable) -> Unit,
    ) {
        collect { result ->
            when (result) {
                is Resources.Success -> onSuccess(result.data)
                is Resources.Failed -> onFailed(result.throwable)
            }
        }
    }
}