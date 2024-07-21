package com.gdg.boss.partTimeJobPosting

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdg.boss.base.BaseScreen

@Composable
fun PartTimeJobPostingScreen(
    viewModel: PartTimeJobPostingViewModel = hiltViewModel()
) {

    val handleEffect: (PartTimeJobPostingContract.PartTimeJobPostingSideEffect) -> Unit = { effect ->
        when(effect) {
            else -> {

            }
        }
    }

    BaseScreen(viewModel = viewModel, handleEffect = handleEffect) { uiState->


    }
}