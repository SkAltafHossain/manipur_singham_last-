package com.altaf.manipursingham.data.remote.api

import com.altaf.manipursingham.data.remote.model.FirstPrizeFirstResponse
import com.altaf.manipursingham.data.remote.model.FirstPrizeJodiResponse
import com.altaf.manipursingham.data.remote.model.LatestResultsPdfResponse

interface DataSource {
    suspend fun getFirstPrizeJodi(): FirstPrizeJodiResponse
    suspend fun getFirstPrizeFirst(): FirstPrizeFirstResponse
    suspend fun getLatestResultsPdf(): LatestResultsPdfResponse
}