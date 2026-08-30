package com.altaf.manipursingham.data.remote.model

import com.altaf.manipursingham.data.remote.dto.LatestResultPdfItemDto

data class LatestResultsPdfResponse(
    val status: String,
    val data: List<LatestResultPdfItemDto>
)
