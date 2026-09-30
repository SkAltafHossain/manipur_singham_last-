package com.altaf.manipursinghamlast.di

import com.altaf.manipursinghamlast.data.repository.FirstPrizeFirstRepositoryImpl
import com.altaf.manipursinghamlast.data.repository.FirstPrizeJodiRepositoryImpl
import com.altaf.manipursinghamlast.data.repository.LatestResultsPdfRepositoryImpl
import com.altaf.manipursinghamlast.domain.repository.FirstPrizeFirstRepository
import com.altaf.manipursinghamlast.domain.repository.FirstPrizeJodiRepository
import com.altaf.manipursinghamlast.domain.repository.LatestResultsPdfRepository
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
