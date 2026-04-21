package com.altaf.haryanalast.di

import com.altaf.haryanalast.data.repository.FirstPrizeFirstRepositoryImpl
import com.altaf.haryanalast.data.repository.FirstPrizeJodiRepositoryImpl
import com.altaf.haryanalast.data.repository.LatestResultsPdfRepositoryImpl
import com.altaf.haryanalast.domain.repository.FirstPrizeFirstRepository
import com.altaf.haryanalast.domain.repository.FirstPrizeJodiRepository
import com.altaf.haryanalast.domain.repository.LatestResultsPdfRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindFirstPrizeJodiRepository(
        firstPrizeJodiRepositoryImpl: FirstPrizeJodiRepositoryImpl
    ): FirstPrizeJodiRepository

    @Binds
    @Singleton
    abstract fun bindFirstPrizeFirstRepository(
        firstPrizeFirstRepositoryImpl: FirstPrizeFirstRepositoryImpl
    ): FirstPrizeFirstRepository
    
    @Binds
    @Singleton
    abstract fun bindLatestResultsPdfRepository(
        latestResultsPdfRepositoryImpl: LatestResultsPdfRepositoryImpl
    ): LatestResultsPdfRepository
}
