package com.gdg.boss.partTimeJobPosting

import androidx.compose.runtime.Immutable
import com.gdg.boss.base.BaseEvent
import com.gdg.boss.base.BaseIntent
import com.gdg.boss.base.BaseSideEffect
import com.gdg.boss.base.UIState

class PartTimeJobPostingContract {

    @Immutable
    data class PartTimeJobPostingUIState(
        val title: String = "",
        val content: String = "",
        val workTime: String = "",
        val hourlyWage: String = "",
        val location: String = ""
    ): UIState

    sealed class PartTimeJobPostingSideEffect: BaseSideEffect{
        object NavigateToDetail: PartTimeJobPostingSideEffect()
    }

    sealed class  PartTimeJobPostingIntent: BaseIntent{
        data class TitleChange(val  title: String): PartTimeJobPostingIntent()
        data class WorkTimeChange(val  time: String): PartTimeJobPostingIntent()
        data class HourlyWageChange(val  money: String): PartTimeJobPostingIntent()
        data class LocationChange(val  location: String): PartTimeJobPostingIntent()
        data class ContentChange(val  content: String): PartTimeJobPostingIntent()
        object PartTimeJobPosting: PartTimeJobPostingIntent()
    }

    sealed class PartTimeJobPostingEvent: BaseEvent {

    }
}