package dev.wxlf.mobint_test_task.presentation.common

import dev.wxlf.mobint_test_task.data.entities.CardEntity

sealed class CardsViewState {

    data class LoadingState(val offset: Int) : CardsViewState()
    data class LoadedState(val data: List<CardEntity>, val isEnd: Boolean) : CardsViewState()
    data class ErrorState(val statusCode: Int, val message: String = "") : CardsViewState()
}
