package com.altaf.manipursinghamlast.domain.repository

import com.altaf.manipursinghamlast.domain.model.FirstPrizeFirst

interface FirstPrizeFirstRepository {
    suspend fun getFirstPrizeFirst(): List<FirstPrizeFirst>
}
