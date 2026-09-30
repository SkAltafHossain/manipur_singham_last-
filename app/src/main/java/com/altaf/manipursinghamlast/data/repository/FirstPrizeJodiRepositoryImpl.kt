package com.altaf.manipursinghamlast.data.repository

import com.altaf.manipursinghamlast.data.remote.api.DataSource
import com.altaf.manipursinghamlast.domain.mapper.FirstPrizeJodiMapper
import com.altaf.manipursinghamlast.domain.model.FirstPrizeJodi
import com.altaf.manipursinghamlast.domain.repository.FirstPrizeJodiRepository
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
