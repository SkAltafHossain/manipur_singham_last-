package com.altaf.haryanalast.data.remote.api

import com.altaf.haryanalast.data.remote.model.FirstPrizeFirstResponse
import com.altaf.haryanalast.data.remote.model.FirstPrizeJodiResponse
import com.altaf.haryanalast.data.remote.model.LatestResultsPdfResponse

interface DataSource {
    suspend fun getFirstPrizeJodi(): FirstPrizeJodiResponse
    suspend fun getFirstPrizeFirst(): FirstPrizeFirstResponse
    suspend fun getLatestResultsPdf(): LatestResultsPdfResponse
}