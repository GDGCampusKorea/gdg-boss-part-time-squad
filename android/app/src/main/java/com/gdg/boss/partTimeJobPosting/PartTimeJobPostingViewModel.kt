package com.gdg.boss.partTimeJobPosting

import androidx.lifecycle.viewModelScope
import com.gdg.boss.base.BaseViewModel
import com.gdg.boss.partTimeJobPosting.PartTimeJobPostingContract.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PartTimeJobPostingViewModel @Inject constructor(
    private val partTimeJobPostingRepository : PartTimeJobPostingRepository
): BaseViewModel<PartTimeJobPostingUIState, PartTimeJobPostingSideEffect, PartTimeJobPostingIntent, PartTimeJobPostingEvent>(
    PartTimeJobPostingUIState()
){

    public override fun handleIntent(intent: PartTimeJobPostingIntent) {
        when(intent){
            is PartTimeJobPostingIntent.WorkTimeChange -> onWorkTimeChange(intent.time)
            is PartTimeJobPostingIntent.ContentChange -> onContentChange(intent.content)
            is PartTimeJobPostingIntent.LocationChange -> onLocationChange(intent.location)
            is PartTimeJobPostingIntent.HourlyWageChange -> onHourlyWageChange(intent.money)
            is PartTimeJobPostingIntent.PartTimeJobPosting -> onPostingClick()
            is PartTimeJobPostingIntent.TitleChange -> onTitleChange(intent.title)
        }
    }

    override fun handleEvent(event: PartTimeJobPostingEvent) {
        TODO("Not yet implemented")
    }

    private fun onWorkTimeChange(workTime: String) {
        setState {
            copy(workTime = workTime)
        }
    }

    private fun onContentChange(content: String) {
        setState {
            copy(content = content)
        }
    }

    private fun onLocationChange(location: String) {
        setState {
            copy(location = location)
        }
    }

    private fun onHourlyWageChange(hourlyWage: String) {
        setState {
            copy(hourlyWage = hourlyWage)
        }
    }

    private fun onTitleChange(title: String) {
        setState {
            copy(title = title)
        }
    }

    private fun onPostingClick() = viewModelScope.launch{

        // 유효성 검사

        partTimeJobPostingRepository.postPartTimeJob(
            request = PostPartTImeJobParm(
                title = currentState.title,
                content = currentState.content,
                workTime = currentState.workTime,
                hourlyWage = currentState.hourlyWage.toInt(),
                location = currentState.location
            )
        )
    }

}