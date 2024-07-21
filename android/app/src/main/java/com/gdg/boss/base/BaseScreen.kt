package com.gdg.boss.base

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun <S : UIState, A : BaseSideEffect, I : BaseIntent, E : BaseEvent> BaseScreen(
    viewModel: BaseViewModel<S, A, I, E>,
    handleEffect: (A) -> Unit = {},
    content: @Composable (S) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is BaseSideEffect.ShowToast -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }
                else -> handleEffect(effect)
            }
        }
    }

    content(uiState)
}