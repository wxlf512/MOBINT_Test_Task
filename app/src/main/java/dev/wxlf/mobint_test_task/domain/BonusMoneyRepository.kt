package dev.wxlf.mobint_test_task.domain

import dev.wxlf.mobint_test_task.data.entities.CardEntity

interface BonusMoneyRepository {

    suspend fun fetchAllCards(offset: Int = 0): List<CardEntity>
    suspend fun fetchAllCardsIdeal(offset: Int = 0): List<CardEntity>
    suspend fun fetchAllCardsLong(offset: Int = 0): List<CardEntity>
    suspend fun fetchAllCardsError(offset: Int = 0): List<CardEntity>
}