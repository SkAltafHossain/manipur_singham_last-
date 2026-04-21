package com.altaf.haryanalast.data.repository

import com.altaf.haryanalast.data.remote.api.DataSource
import com.altaf.haryanalast.domain.mapper.FirstPrizeJodiMapper
import com.altaf.haryanalast.domain.model.FirstPrizeJodi
import com.altaf.haryanalast.domain.repository.FirstPrizeJodiRepository
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
