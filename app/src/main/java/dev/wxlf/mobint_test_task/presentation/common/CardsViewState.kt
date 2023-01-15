package dev.wxlf.mobint_test_task.presentation.common

import dev.wxlf.mobint_test_task.data.entities.CardEntity

sealed class CardsViewState {

    object LoadingState : CardsViewState()
    data class LoadedState(val data: List<CardEntity>) : CardsViewState()
}
