package com.altaf.manipursingham.data.remote.model

import com.altaf.manipursingham.data.remote.dto.FirstPrizeJodiDto

data class FirstPrizeJodiResponse(
    val status: String,
    val data: MutableList<FirstPrizeJodiDto>
)
