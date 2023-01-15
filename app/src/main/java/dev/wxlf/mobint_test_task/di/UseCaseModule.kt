package dev.wxlf.mobint_test_task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.wxlf.mobint_test_task.domain.BonusMoneyRepository
import dev.wxlf.mobint_test_task.domain.usecases.FetchAllCardsErrorUseCase
import dev.wxlf.mobint_test_task.domain.usecases.FetchAllCardsIdealUseCase
import dev.wxlf.mobint_test_task.domain.usecases.FetchAllCardsLongUseCase
import dev.wxlf.mobint_test_task.domain.usecases.FetchAllCardsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideFetchAllCardsUseCase(repository: BonusMoneyRepository) =
        FetchAllCardsUseCase(repository)

    @Provides
    @Singleton
    fun provideFetchAllCardsIdealUseCase(repository: BonusMoneyRepository) =
        FetchAllCardsIdealUseCase(repository)

    @Provides
    @Singleton
    fun provideFetchAllCardsLongUseCase(repository: BonusMoneyRepository) =
        FetchAllCardsLongUseCase(repository)

    @Provides
    @Singleton
    fun provideFetchAllCardsErrorUseCase(repository: BonusMoneyRepository) =
        FetchAllCardsErrorUseCase(repository)
}