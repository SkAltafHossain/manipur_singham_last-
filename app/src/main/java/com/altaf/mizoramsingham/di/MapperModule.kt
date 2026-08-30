package com.altaf.manipursingham.di

import com.altaf.manipursingham.domain.mapper.FirstPrizeFirstMapper
import com.altaf.manipursingham.domain.mapper.FirstPrizeFirstMapperImpl
import com.altaf.manipursingham.domain.mapper.FirstPrizeJodiMapper
import com.altaf.manipursingham.domain.mapper.FirstPrizeJodiMapperImpl
import com.altaf.manipursingham.domain.mapper.LatestResultsPdfMapper
import com.altaf.manipursingham.domain.mapper.LatestResultsPdfMapperImpl
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
