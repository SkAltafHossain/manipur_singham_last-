package com.kerala.lastkerala.data.repository

import com.kerala.lastkerala.data.remote.api.DataSource
import com.kerala.lastkerala.domain.mapper.FirstPrizeFirstMapper
import com.kerala.lastkerala.domain.model.FirstPrizeFirst
import com.kerala.lastkerala.domain.repository.FirstPrizeFirstRepository
import javax.inject.Inject

class FirstPrizeFirstRepositoryImpl @Inject constructor(
    private val remoteDataSource: DataSource,
    private val mapper: FirstPrizeFirstMapper
) : FirstPrizeFirstRepository {

    override suspend fun getFirstPrizeFirst(): List<FirstPrizeFirst> {
        val response = remoteDataSource.getFirstPrizeFirst()
        return mapper.mapToDomainList(response.data)
    }
}
