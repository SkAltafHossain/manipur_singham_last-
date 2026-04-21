package com.altaf.haryanalast.data.repository

import com.altaf.haryanalast.data.remote.api.DataSource
import com.altaf.haryanalast.domain.mapper.FirstPrizeFirstMapper
import com.altaf.haryanalast.domain.model.FirstPrizeFirst
import com.altaf.haryanalast.domain.repository.FirstPrizeFirstRepository
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
