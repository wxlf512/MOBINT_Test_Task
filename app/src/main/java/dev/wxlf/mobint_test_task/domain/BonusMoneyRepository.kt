package dev.wxlf.mobint_test_task.domain

import dev.wxlf.mobint_test_task.data.entities.CardEntity

interface BonusMoneyRepository {

    suspend fun fetchAllCards(): List<CardEntity>
    suspend fun fetchAllCardsIdeal(): List<CardEntity>
    suspend fun fetchAllCardsLong(): List<CardEntity>
    suspend fun fetchAllCardsError(): List<CardEntity>
}