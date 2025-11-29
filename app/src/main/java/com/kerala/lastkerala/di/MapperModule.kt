package com.kerala.lastkerala.di

import com.kerala.lastkerala.domain.mapper.FirstPrizeFirstMapper
import com.kerala.lastkerala.domain.mapper.FirstPrizeFirstMapperImpl
import com.kerala.lastkerala.domain.mapper.FirstPrizeJodiMapper
import com.kerala.lastkerala.domain.mapper.FirstPrizeJodiMapperImpl
import com.kerala.lastkerala.domain.mapper.LatestResultsPdfMapper
import com.kerala.lastkerala.domain.mapper.LatestResultsPdfMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {
    @Binds
    @Singleton
    abstract fun bindFirstPrizeJodiMapper(impl: FirstPrizeJodiMapperImpl): FirstPrizeJodiMapper
    
    @Binds
    @Singleton
    abstract fun bindFirstPrizeFirstMapper(impl: FirstPrizeFirstMapperImpl): FirstPrizeFirstMapper
    
    @Binds
    @Singleton
    abstract fun bindLatestResultsPdfMapper(impl: LatestResultsPdfMapperImpl): LatestResultsPdfMapper
}
