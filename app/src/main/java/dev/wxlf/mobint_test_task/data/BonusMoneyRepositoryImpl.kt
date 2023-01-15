package dev.wxlf.mobint_test_task.data

import dev.wxlf.mobint_test_task.data.datasources.remote.BonusMoneyRemoteDataSource
import dev.wxlf.mobint_test_task.data.entities.CardEntity
import dev.wxlf.mobint_test_task.domain.BonusMoneyRepository

class BonusMoneyRepositoryImpl(private val remote: BonusMoneyRemoteDataSource) : BonusMoneyRepository {
    override suspend fun fetchAllCards(): List<CardEntity> =
        remote.loadAllCards()

    override suspend fun fetchAllCardsIdeal(): List<CardEntity> =
        remote.loadAllCardsIdeal()

    override suspend fun fetchAllCardsLong(): List<CardEntity> =
        remote.loadAllCardsLong()

    override suspend fun fetchAllCardsError(): List<CardEntity> =
        remote.loadAllCardsError()
}