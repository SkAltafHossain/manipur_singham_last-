package com.altaf.manipursingham.di

import com.altaf.manipursingham.data.repository.FirstPrizeFirstRepositoryImpl
import com.altaf.manipursingham.data.repository.FirstPrizeJodiRepositoryImpl
import com.altaf.manipursingham.data.repository.LatestResultsPdfRepositoryImpl
import com.altaf.manipursingham.domain.repository.FirstPrizeFirstRepository
import com.altaf.manipursingham.domain.repository.FirstPrizeJodiRepository
import com.altaf.manipursingham.domain.repository.LatestResultsPdfRepository
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
