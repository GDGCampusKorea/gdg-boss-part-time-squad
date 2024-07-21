package com.gdg.boss.partTimeJobPosting

import com.gdg.boss.base.BaseViewModel
import com.gdg.boss.partTimeJobPosting.PartTimeJobPostingContract.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PartTimeJobPostingViewModel @Inject constructor(

): BaseViewModel<PartTimeJobPostingUIState, PartTimeJobPostingSideEffect, PartTimeJobPostingIntent, PartTimeJobPostingEvent>(
    PartTimeJobPostingUIState()
){

    override fun handleIntent(intent: PartTimeJobPostingIntent) {
        TODO("Not yet implemented")
    }

    override fun handleEvent(event: PartTimeJobPostingEvent) {
        TODO("Not yet implemented")
    }

}