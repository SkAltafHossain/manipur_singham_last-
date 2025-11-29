package com.kerala.lastkerala.data.remote.api

import android.util.Log
import com.kerala.lastkerala.common.extension.toSimpleJson
import com.kerala.lastkerala.data.remote.model.FirstPrizeFirstResponse
import com.kerala.lastkerala.data.remote.model.FirstPrizeJodiResponse
import com.kerala.lastkerala.data.remote.model.LatestResultsPdfResponse

class DataSourceImpl(
    private val apiService: ApiService
) : DataSource {
    override suspend fun getFirstPrizeJodi(): FirstPrizeJodiResponse {
        val response = apiService.getFirstPrizeJodi()
        if (response.isSuccessful) {
            Log.d("TAG", "getFirstPrizeJodi: ${response.body()}")
            return response.body() ?: throw Exception("Empty response body")
        } else {
            throw Exception("Failed to fetch data: ${response.code()} ${response.message()}")
        }
    }

    override suspend fun getFirstPrizeFirst(): FirstPrizeFirstResponse {
        val response = apiService.getFirstPrizeFirst()
        if (response.isSuccessful) {
            Log.d("TAG", "getFirstPrizeJodi: ${response.body()}")
            return response.body() ?: throw Exception("Empty response body")
        } else {
            throw Exception("Failed to fetch data: ${response.code()} ${response.message()}")
        }
    }
    
    override suspend fun getLatestResultsPdf(): LatestResultsPdfResponse {
        val response = apiService.getLatestResultsPdf()
        if (response.isSuccessful) {
            Log.d("TAG", "getLatestResultsPdf: ${response.body()}")
            return response.body() ?: throw Exception("Empty response body")
        } else {
            throw Exception("Failed to fetch data: ${response.code()} ${response.message()}")
        }
    }
}