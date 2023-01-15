package dev.wxlf.mobint_test_task.data

import dev.wxlf.mobint_test_task.data.entities.CardEntity
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface BonusMoneyAPI {

    @Headers("TOKEN: 123")
    @POST("./getAllCompanies")
    suspend fun loadAllCards(@Body params: RequestBody = "{\"offset\": 0}".toRequestBody()): List<CardEntity>

    @Headers("TOKEN: 123")
    @POST("./getAllCompaniesIdeal")
    suspend fun loadAllCardsIdeal(@Body params: RequestBody = "{\"offset\": 0}".toRequestBody()): List<CardEntity>

    @Headers("TOKEN: 123")
    @POST("./getAllCompaniesLong")
    suspend fun loadAllCardsLong(@Body params: RequestBody = "{\"offset\": 0}".toRequestBody()): List<CardEntity>

    @Headers("TOKEN: 123")
    @POST("./getAllCompaniesError")
    suspend fun loadAllCardsError(@Body params: RequestBody = "{\"offset\": 0}".toRequestBody()): List<CardEntity>
}