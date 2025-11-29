package com.kerala.lastkerala.data.repository

import com.kerala.lastkerala.data.remote.api.DataSource
import com.kerala.lastkerala.domain.mapper.LatestResultsPdfMapper
import com.kerala.lastkerala.domain.model.LatestResultPdf
import com.kerala.lastkerala.domain.repository.LatestResultsPdfRepository
import javax.inject.Inject

class LatestResultsPdfRepositoryImpl @Inject constructor(
    private val remoteDataSource: DataSource,
    private val mapper: LatestResultsPdfMapper
) : LatestResultsPdfRepository {

    override suspend fun getLatestResultsPdf(): List<LatestResultPdf> {
        val response = remoteDataSource.getLatestResultsPdf()
        return mapper.mapToDomainList(response.data)
    }
}
