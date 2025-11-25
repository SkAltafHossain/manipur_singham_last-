package com.kerala.lastkerala.data.repository

import com.kerala.lastkerala.data.remote.api.DataSource
import com.kerala.lastkerala.domain.mapper.FirstPrizeJodiMapper
import com.kerala.lastkerala.domain.model.FirstPrizeJodi
import com.kerala.lastkerala.domain.repository.FirstPrizeJodiRepository
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
