package dev.wxlf.mobint_test_task.data.datasources.remote

import dev.wxlf.mobint_test_task.data.BonusMoneyAPI
import dev.wxlf.mobint_test_task.data.entities.CardEntity
import okhttp3.RequestBody.Companion.toRequestBody

class RetrofitBonusMoneyDataSource(private val api: BonusMoneyAPI) : BonusMoneyRemoteDataSource{

    override suspend fun loadAllCards(offset: Int): List<CardEntity> =
        api.loadAllCards("{\"offset\": $offset}".toRequestBody())

    override suspend fun loadAllCardsIdeal(offset: Int): List<CardEntity> =
        api.loadAllCardsIdeal("{\"offset\": $offset}".toRequestBody())

    override suspend fun loadAllCardsLong(offset: Int): List<CardEntity> =
        api.loadAllCardsLong("{\"offset\": $offset}".toRequestBody())

    override suspend fun loadAllCardsError(offset: Int): List<CardEntity> =
        api.loadAllCardsError("{\"offset\": $offset}".toRequestBody())
}