package dev.wxlf.mobint_test_task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.wxlf.mobint_test_task.data.BonusMoneyAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideGson() : GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideBonusMoneyAPI(okHttpClient: OkHttpClient, gson: GsonConverterFactory): BonusMoneyAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://dev.bonusmoney.pro/mobileapp/")
            .client(okHttpClient)
            .addConverterFactory(gson)
            .build()
        return retrofit.create(BonusMoneyAPI::class.java)
    }
}