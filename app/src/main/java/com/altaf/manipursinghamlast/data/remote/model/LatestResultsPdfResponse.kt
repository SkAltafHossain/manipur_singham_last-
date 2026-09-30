package com.altaf.manipursinghamlast.data.remote.model

import com.altaf.manipursinghamlast.data.remote.dto.LatestResultPdfItemDto

data class LatestResultsPdfResponse(
    val status: String,
    val data: List<LatestResultPdfItemDto>
)
