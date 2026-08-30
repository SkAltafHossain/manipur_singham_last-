package com.altaf.manipursingham.data.repository

import com.altaf.manipursingham.data.remote.api.DataSource
import com.altaf.manipursingham.domain.mapper.LatestResultsPdfMapper
import com.altaf.manipursingham.domain.model.LatestResultPdf
import com.altaf.manipursingham.domain.repository.LatestResultsPdfRepository
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
