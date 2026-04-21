package com.altaf.haryanalast.data.remote.model

import com.altaf.haryanalast.data.remote.dto.FirstPrizeFirstDto

data class FirstPrizeFirstResponse(
    val status: String,
    val data: List<FirstPrizeFirstDto>
)
