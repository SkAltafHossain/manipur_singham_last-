package com.kerala.lastkerala.di

import com.kerala.lastkerala.domain.usecase.firstPrizeFast.FirstPrizeFirstUseCase
import com.kerala.lastkerala.domain.usecase.firstPrizeFast.FirstPrizeFirstUseCaseImpl
import com.kerala.lastkerala.domain.usecase.firstPrizeJodi.FirstPrizeJodiUseCase
import com.kerala.lastkerala.domain.usecase.firstPrizeJodi.FirstPrizeJodiUseCaseImpl
import com.kerala.lastkerala.domain.usecase.latestresultspdf.LatestResultsPdfUseCase
import com.kerala.lastkerala.domain.usecase.latestresultspdf.LatestResultsPdfUseCaseImpl
import com.kerala.lastkerala.domain.usecase.numberCombination.NumberCombinationUseCase
import com.kerala.lastkerala.domain.usecase.numberCombination.NumberCombinationUseCaseImpl
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

    @Binds
    @Singleton
    fun bindNumberCombinationUseCase(
        impl: NumberCombinationUseCaseImpl
    ): NumberCombinationUseCase
    
    @Binds
    @Singleton
    fun bindLatestResultsPdfUseCase(
        impl: LatestResultsPdfUseCaseImpl
    ): LatestResultsPdfUseCase
}