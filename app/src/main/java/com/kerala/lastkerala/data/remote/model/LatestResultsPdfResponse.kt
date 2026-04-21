package com.altaf.haryanalast.data.remote.model

import com.altaf.haryanalast.data.remote.dto.LatestResultPdfItemDto

data class LatestResultsPdfResponse(
    val status: String,
    val data: List<LatestResultPdfItemDto>
)
