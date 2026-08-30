package com.altaf.manipursingham.domain.repository

import com.altaf.manipursingham.domain.model.FirstPrizeJodi

interface FirstPrizeJodiRepository {
    suspend fun getFirstPrizeJodi(): MutableList<FirstPrizeJodi>
}
