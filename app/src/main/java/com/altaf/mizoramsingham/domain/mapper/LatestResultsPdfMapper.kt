package com.altaf.manipursinghamlast.domain.mapper

import com.altaf.manipursinghamlast.data.remote.dto.LatestResultPdfItemDto
import com.altaf.manipursinghamlast.domain.model.LatestResultPdf
import javax.inject.Inject

interface LatestResultsPdfMapper {
    fun mapToDomainList(dtos: List<LatestResultPdfItemDto>): MutableList<LatestResultPdf>
}

class LatestResultsPdfMapperImpl @Inject constructor() : LatestResultsPdfMapper {
    override fun mapToDomainList(dtos: List<LatestResultPdfItemDto>): MutableList<LatestResultPdf> {
        return dtos.map { it.toLatestResultPdf() }.toMutableList()
    }
}
