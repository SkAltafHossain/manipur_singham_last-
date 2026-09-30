package com.altaf.manipursinghamlast.data.remote.model

import com.altaf.manipursinghamlast.data.remote.dto.FirstPrizeJodiDto

data class FirstPrizeJodiResponse(
    val status: String,
    val data: MutableList<FirstPrizeJodiDto>
)
