package com.altaf.manipursinghamlast.data.remote.api

import com.altaf.manipursinghamlast.data.remote.model.FirstPrizeFirstResponse
import com.altaf.manipursinghamlast.data.remote.model.FirstPrizeJodiResponse
import com.altaf.manipursinghamlast.data.remote.model.LatestResultsPdfResponse

interface DataSource {
    suspend fun getFirstPrizeJodi(): FirstPrizeJodiResponse
    suspend fun getFirstPrizeFirst(): FirstPrizeFirstResponse
    suspend fun getLatestResultsPdf(): LatestResultsPdfResponse
}