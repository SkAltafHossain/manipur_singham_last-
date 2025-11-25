package com.kerala.lastkerala.di

import com.kerala.lastkerala.data.repository.FirstPrizeJodiRepositoryImpl
import com.kerala.lastkerala.domain.repository.FirstPrizeJodiRepository
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
}
