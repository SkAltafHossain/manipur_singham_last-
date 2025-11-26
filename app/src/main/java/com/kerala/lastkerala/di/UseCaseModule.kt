package com.kerala.lastkerala.di

import com.kerala.lastkerala.domain.usecase.firstPrizeFast.FirstPrizeFirstUseCase
import com.kerala.lastkerala.domain.usecase.firstPrizeFast.FirstPrizeFirstUseCaseImpl
import com.kerala.lastkerala.domain.usecase.firstPrizeJodi.FirstPrizeJodiUseCase
import com.kerala.lastkerala.domain.usecase.firstPrizeJodi.FirstPrizeJodiUseCaseImpl
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

    @Binds
    @Singleton
    fun bindFirstPrizeFirstUseCase(
        impl: FirstPrizeFirstUseCaseImpl
    ): FirstPrizeFirstUseCase
}