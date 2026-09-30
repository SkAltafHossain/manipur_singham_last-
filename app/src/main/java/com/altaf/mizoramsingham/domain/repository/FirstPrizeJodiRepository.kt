package com.altaf.manipursinghamlast.domain.repository

import com.altaf.manipursinghamlast.domain.model.FirstPrizeJodi

interface FirstPrizeJodiRepository {
    suspend fun getFirstPrizeJodi(): MutableList<FirstPrizeJodi>
}
