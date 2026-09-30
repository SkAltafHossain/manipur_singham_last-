package com.altaf.manipursinghamlast.di

import com.altaf.manipursinghamlast.data.remote.api.ApiService
import com.altaf.manipursinghamlast.data.remote.api.DataSource
import com.altaf.manipursinghamlast.data.remote.api.DataSourceImpl
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
