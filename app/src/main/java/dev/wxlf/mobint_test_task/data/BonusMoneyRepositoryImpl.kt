package dev.wxlf.mobint_test_task.data

import dev.wxlf.mobint_test_task.data.datasources.remote.BonusMoneyRemoteDataSource
import dev.wxlf.mobint_test_task.data.entities.CardEntity
import dev.wxlf.mobint_test_task.domain.BonusMoneyRepository

class BonusMoneyRepositoryImpl(private val remote: BonusMoneyRemoteDataSource) : BonusMoneyRepository {
    override suspend fun fetchAllCards(offset: Int): List<CardEntity> =
        remote.loadAllCards(offset)

    override suspend fun fetchAllCardsIdeal(offset: Int): List<CardEntity> =
        remote.loadAllCardsIdeal(offset)

    override suspend fun fetchAllCardsLong(offset: Int): List<CardEntity> =
        remote.loadAllCardsLong(offset)

    override suspend fun fetchAllCardsError(offset: Int): List<CardEntity> =
        remote.loadAllCardsError(offset)
}