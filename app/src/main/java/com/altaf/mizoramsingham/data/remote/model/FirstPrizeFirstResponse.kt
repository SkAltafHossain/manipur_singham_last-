package com.altaf.manipursinghamlast.data.remote.model

import com.altaf.manipursinghamlast.data.remote.dto.FirstPrizeFirstDto

data class FirstPrizeFirstResponse(
    val status: String,
    val data: List<FirstPrizeFirstDto>
)
