package com.altaf.manipursinghamlast.data.repository

import com.altaf.manipursinghamlast.data.remote.api.DataSource
import com.altaf.manipursinghamlast.domain.mapper.FirstPrizeFirstMapper
import com.altaf.manipursinghamlast.domain.model.FirstPrizeFirst
import com.altaf.manipursinghamlast.domain.repository.FirstPrizeFirstRepository
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
