package com.altaf.manipursingham.data.remote.model

import com.altaf.manipursingham.data.remote.dto.FirstPrizeFirstDto

data class FirstPrizeFirstResponse(
    val status: String,
    val data: List<FirstPrizeFirstDto>
)
