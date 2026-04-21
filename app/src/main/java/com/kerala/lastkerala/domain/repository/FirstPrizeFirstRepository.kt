package com.altaf.haryanalast.domain.repository

import com.altaf.haryanalast.common.result.NetworkResult
import com.altaf.haryanalast.domain.model.FirstPrizeFirst

interface FirstPrizeFirstRepository {
    suspend fun getFirstPrizeFirst(): List<FirstPrizeFirst>
}
