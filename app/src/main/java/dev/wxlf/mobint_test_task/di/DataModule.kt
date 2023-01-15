package dev.wxlf.mobint_test_task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.wxlf.mobint_test_task.data.BonusMoneyAPI
import dev.wxlf.mobint_test_task.data.BonusMoneyRepositoryImpl
import dev.wxlf.mobint_test_task.data.datasources.remote.BonusMoneyRemoteDataSource
import dev.wxlf.mobint_test_task.data.datasources.remote.RetrofitBonusMoneyDataSource
import dev.wxlf.mobint_test_task.domain.BonusMoneyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofitBonusMoneyDataSource(bonusMoneyAPI: BonusMoneyAPI): BonusMoneyRemoteDataSource =
        RetrofitBonusMoneyDataSource(bonusMoneyAPI)

    @Provides
    @Singleton
    fun provideBonusMoneyRepository(bonusMoneyRemoteDataSource: BonusMoneyRemoteDataSource): BonusMoneyRepository =
        BonusMoneyRepositoryImpl(bonusMoneyRemoteDataSource)
}