package com.altaf.manipursingham.di

import com.altaf.manipursingham.data.remote.api.ApiService
import com.altaf.manipursingham.data.remote.api.DataSource
import com.altaf.manipursingham.data.remote.api.DataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDataSource(apiService: ApiService): DataSource {
        return DataSourceImpl(apiService)
    }
}
