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
        val time: String = "",
        val money: String = "",
        val location: String = "",
        val content: String = ""
    ): UIState

    sealed class PartTimeJobPostingSideEffect: BaseSideEffect{
        object NavigateToDetail: PartTimeJobPostingSideEffect()
    }

    sealed class  PartTimeJobPostingIntent: BaseIntent{
        data class TitleChange(val  title: String): PartTimeJobPostingIntent()
        data class TimeChange(val  time: String): PartTimeJobPostingIntent()
        data class MoneyChange(val  money: String): PartTimeJobPostingIntent()
        data class LocationChange(val  location: String): PartTimeJobPostingIntent()
        data class ContentChange(val  content: String): PartTimeJobPostingIntent()
        object PartTimeJobPosting: PartTimeJobPostingIntent()
    }

    sealed class PartTimeJobPostingEvent: BaseEvent {

    }
}