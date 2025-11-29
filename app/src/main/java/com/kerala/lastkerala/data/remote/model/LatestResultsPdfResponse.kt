package com.kerala.lastkerala.data.remote.model

import com.kerala.lastkerala.data.remote.dto.LatestResultPdfItemDto

data class LatestResultsPdfResponse(
    val status: String,
    val data: List<LatestResultPdfItemDto>
)
