package com.altaf.haryanalast.data.repository

import com.altaf.haryanalast.data.remote.api.DataSource
import com.altaf.haryanalast.domain.mapper.LatestResultsPdfMapper
import com.altaf.haryanalast.domain.model.LatestResultPdf
import com.altaf.haryanalast.domain.repository.LatestResultsPdfRepository
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
