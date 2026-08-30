package com.altaf.manipursingham.di

import com.altaf.manipursingham.domain.usecase.firstPrizeFast.FirstPrizeFirstUseCase
import com.altaf.manipursingham.domain.usecase.firstPrizeFast.FirstPrizeFirstUseCaseImpl
import com.altaf.manipursingham.domain.usecase.firstPrizeJodi.FirstPrizeJodiUseCase
import com.altaf.manipursingham.domain.usecase.firstPrizeJodi.FirstPrizeJodiUseCaseImpl
import com.altaf.manipursingham.domain.usecase.latestresultspdf.LatestResultsPdfUseCase
import com.altaf.manipursingham.domain.usecase.latestresultspdf.LatestResultsPdfUseCaseImpl
import com.altaf.manipursingham.domain.usecase.numberCombination.NumberCombinationUseCase
import com.altaf.manipursingham.domain.usecase.numberCombination.NumberCombinationUseCaseImpl
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