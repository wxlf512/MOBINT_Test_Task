package dev.wxlf.mobint_test_task.domain.usecases

import dev.wxlf.mobint_test_task.domain.BonusMoneyRepository


class FetchAllCardsUseCase(private val repository: BonusMoneyRepository) {
    suspend fun execute(offset: Int) = repository.fetchAllCards(offset)
}