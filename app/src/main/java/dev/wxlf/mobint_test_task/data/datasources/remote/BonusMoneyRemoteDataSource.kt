package dev.wxlf.mobint_test_task.data.datasources.remote

import dev.wxlf.mobint_test_task.data.entities.CardEntity

interface BonusMoneyRemoteDataSource {

    suspend fun loadAllCards(): List<CardEntity>
    suspend fun loadAllCardsIdeal(): List<CardEntity>
    suspend fun loadAllCardsLong(): List<CardEntity>
    suspend fun loadAllCardsError(): List<CardEntity>
}