package com.kerala.lastkerala.domain.repository

import com.kerala.lastkerala.domain.model.FirstPrizeJodi

interface FirstPrizeJodiRepository {
    suspend fun getFirstPrizeJodi(): MutableList<FirstPrizeJodi>
}
