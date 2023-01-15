package dev.wxlf.mobint_test_task.data.datasources.remote

import dev.wxlf.mobint_test_task.data.entities.CardEntity

interface BonusMoneyRemoteDataSource {

    suspend fun loadAllCards(offset: Int): List<CardEntity>
    suspend fun loadAllCardsIdeal(offset: Int): List<CardEntity>
    suspend fun loadAllCardsLong(offset: Int): List<CardEntity>
    suspend fun loadAllCardsError(offset: Int): List<CardEntity>
}