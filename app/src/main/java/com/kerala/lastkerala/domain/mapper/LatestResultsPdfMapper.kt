package com.kerala.lastkerala.domain.mapper

import com.kerala.lastkerala.data.remote.dto.LatestResultPdfItemDto
import com.kerala.lastkerala.domain.model.LatestResultPdf
import javax.inject.Inject

interface LatestResultsPdfMapper {
    fun mapToDomainList(dtos: List<LatestResultPdfItemDto>): MutableList<LatestResultPdf>
}

class LatestResultsPdfMapperImpl @Inject constructor() : LatestResultsPdfMapper {
    override fun mapToDomainList(dtos: List<LatestResultPdfItemDto>): MutableList<LatestResultPdf> {
        return dtos.map { it.toLatestResultPdf() }.toMutableList()
    }
}
