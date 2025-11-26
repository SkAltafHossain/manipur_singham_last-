package com.kerala.lastkerala.domain.repository

import com.kerala.lastkerala.common.result.NetworkResult
import com.kerala.lastkerala.domain.model.FirstPrizeFirst

interface FirstPrizeFirstRepository {
    suspend fun getFirstPrizeFirst(): MutableList<FirstPrizeFirst>
}
