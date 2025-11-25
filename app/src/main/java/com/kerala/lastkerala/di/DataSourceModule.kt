package com.kerala.lastkerala.di

import com.kerala.lastkerala.data.remote.api.ApiService
import com.kerala.lastkerala.data.remote.api.DataSource
import com.kerala.lastkerala.data.remote.api.DataSourceImpl
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
