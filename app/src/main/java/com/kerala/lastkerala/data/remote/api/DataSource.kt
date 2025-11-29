package com.kerala.lastkerala.data.remote.api

import com.kerala.lastkerala.data.remote.model.FirstPrizeFirstResponse
import com.kerala.lastkerala.data.remote.model.FirstPrizeJodiResponse
import com.kerala.lastkerala.data.remote.model.LatestResultsPdfResponse

interface DataSource {
    suspend fun getFirstPrizeJodi(): FirstPrizeJodiResponse
    suspend fun getFirstPrizeFirst(): FirstPrizeFirstResponse
    suspend fun getLatestResultsPdf(): LatestResultsPdfResponse
}