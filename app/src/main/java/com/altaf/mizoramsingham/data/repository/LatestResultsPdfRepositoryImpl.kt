package com.altaf.manipursinghamlast.data.repository

import com.altaf.manipursinghamlast.data.remote.api.DataSource
import com.altaf.manipursinghamlast.domain.mapper.LatestResultsPdfMapper
import com.altaf.manipursinghamlast.domain.model.LatestResultPdf
import com.altaf.manipursinghamlast.domain.repository.LatestResultsPdfRepository
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
