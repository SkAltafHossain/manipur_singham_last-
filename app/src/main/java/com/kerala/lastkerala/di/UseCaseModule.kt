package com.kerala.lastkerala.di

import com.kerala.lastkerala.domain.usecase.FirstPrizeJodiUseCase
import com.kerala.lastkerala.domain.usecase.FirstPrizeJodiUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    @Singleton
    fun bindFirstPrizeJodiUseCase(
        impl: FirstPrizeJodiUseCaseImpl
    ): FirstPrizeJodiUseCase
}