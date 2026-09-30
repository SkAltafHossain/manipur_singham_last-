package com.altaf.manipursinghamlast.data.remote.api

import com.altaf.manipursinghamlast.data.remote.model.FirstPrizeFirstResponse
import com.altaf.manipursinghamlast.data.remote.model.FirstPrizeJodiResponse
import com.altaf.manipursinghamlast.data.remote.model.LatestResultsPdfResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("first-price-jodi")
    suspend fun getFirstPrizeJodi(): Response<FirstPrizeJodiResponse>
    
    @GET("first-price-last")
    suspend fun getFirstPrizeFirst(): Response<FirstPrizeFirstResponse>
    
    @GET("latest-results-pdf")
    suspend fun getLatestResultsPdf(): Response<LatestResultsPdfResponse>
}