package com.kerala.lastkerala.data.remote.api

import com.kerala.lastkerala.data.remote.model.FirstPrizeFirstResponse
import com.kerala.lastkerala.data.remote.model.FirstPrizeJodiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("first-price-jodi")
    suspend fun getFirstPrizeJodi(): Response<FirstPrizeJodiResponse>
    
    @GET("first-price-last")
    suspend fun getFirstPrizeFirst(): Response<FirstPrizeFirstResponse>
}