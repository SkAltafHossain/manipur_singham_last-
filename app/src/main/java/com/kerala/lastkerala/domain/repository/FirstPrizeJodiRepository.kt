package com.altaf.haryanalast.domain.repository

import com.altaf.haryanalast.domain.model.FirstPrizeJodi

interface FirstPrizeJodiRepository {
    suspend fun getFirstPrizeJodi(): MutableList<FirstPrizeJodi>
}
