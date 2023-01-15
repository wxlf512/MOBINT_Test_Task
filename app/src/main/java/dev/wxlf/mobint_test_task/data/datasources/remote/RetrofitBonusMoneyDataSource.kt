package dev.wxlf.mobint_test_task.data.datasources.remote

import dev.wxlf.mobint_test_task.data.BonusMoneyAPI
import dev.wxlf.mobint_test_task.data.entities.CardEntity

class RetrofitBonusMoneyDataSource(private val api: BonusMoneyAPI) : BonusMoneyRemoteDataSource{

    override suspend fun loadAllCards(): List<CardEntity> =
        api.loadAllCards()

    override suspend fun loadAllCardsIdeal(): List<CardEntity> =
        api.loadAllCardsIdeal()

    override suspend fun loadAllCardsLong(): List<CardEntity> =
        api.loadAllCardsLong()

    override suspend fun loadAllCardsError(): List<CardEntity> =
        api.loadAllCardsError()
}