package com.kerala.lastkerala.data.remote.api

import com.kerala.lastkerala.data.remote.model.FirstPrizeJodiResponse

interface DataSource {
    suspend fun getFirstPrizeJodi(): FirstPrizeJodiResponse
}