package com.altaf.manipursingham.data.repository

import com.altaf.manipursingham.data.remote.api.DataSource
import com.altaf.manipursingham.domain.mapper.FirstPrizeFirstMapper
import com.altaf.manipursingham.domain.model.FirstPrizeFirst
import com.altaf.manipursingham.domain.repository.FirstPrizeFirstRepository
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
