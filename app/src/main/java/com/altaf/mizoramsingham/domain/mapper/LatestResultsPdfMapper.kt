package com.altaf.manipursingham.domain.mapper

import com.altaf.manipursingham.data.remote.dto.LatestResultPdfItemDto
import com.altaf.manipursingham.domain.model.LatestResultPdf
import javax.inject.Inject

interface LatestResultsPdfMapper {
    fun mapToDomainList(dtos: List<LatestResultPdfItemDto>): MutableList<LatestResultPdf>
}

class LatestResultsPdfMapperImpl @Inject constructor() : LatestResultsPdfMapper {
    override fun mapToDomainList(dtos: List<LatestResultPdfItemDto>): MutableList<LatestResultPdf> {
        return dtos.map { it.toLatestResultPdf() }.toMutableList()
    }
}
