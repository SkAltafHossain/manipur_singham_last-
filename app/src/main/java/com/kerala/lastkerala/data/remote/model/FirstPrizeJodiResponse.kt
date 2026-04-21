package com.altaf.haryanalast.data.remote.model

import com.altaf.haryanalast.data.remote.dto.FirstPrizeJodiDto

data class FirstPrizeJodiResponse(
    val status: String,
    val data: MutableList<FirstPrizeJodiDto>
)
