package com.kerala.lastkerala.data.remote.model

import com.kerala.lastkerala.data.remote.dto.FirstPrizeJodiDto

data class FirstPrizeJodiResponse(
    val status: String,
    val data: MutableList<FirstPrizeJodiDto>
)
