package dev.wxlf.mobint_test_task.presentation.common

sealed class CardsEvent {
    data class LoadCardsEvent(val offset: Int) : CardsEvent()
}
