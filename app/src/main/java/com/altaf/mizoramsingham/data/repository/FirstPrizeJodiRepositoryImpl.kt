package com.altaf.manipursingham.data.repository

import com.altaf.manipursingham.data.remote.api.DataSource
import com.altaf.manipursingham.domain.mapper.FirstPrizeJodiMapper
import com.altaf.manipursingham.domain.model.FirstPrizeJodi
import com.altaf.manipursingham.domain.repository.FirstPrizeJodiRepository
import javax.inject.Inject

class FirstPrizeJodiRepositoryImpl @Inject constructor(
    private val remoteDataSource: DataSource,
    private val mapper: FirstPrizeJodiMapper
) : FirstPrizeJodiRepository {

    override suspend fun getFirstPrizeJodi(): MutableList<FirstPrizeJodi> {
        val response = remoteDataSource.getFirstPrizeJodi()
        return mapper.mapToDomainList(response.data)
    }
}
