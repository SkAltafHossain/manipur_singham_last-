package com.altaf.manipursingham.domain.repository

import com.altaf.manipursingham.domain.model.FirstPrizeFirst

interface FirstPrizeFirstRepository {
    suspend fun getFirstPrizeFirst(): List<FirstPrizeFirst>
}
