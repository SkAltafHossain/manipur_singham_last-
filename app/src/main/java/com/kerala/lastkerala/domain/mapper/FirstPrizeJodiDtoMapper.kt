package com.kerala.lastkerala.domain.mapper

import com.kerala.lastkerala.domain.model.FirstPrizeJodi
import com.kerala.lastkerala.data.remote.dto.FirstPrizeJodiDto
import javax.inject.Inject

interface FirstPrizeJodiMapper {
    fun mapToDomainList(dtos: MutableList<FirstPrizeJodiDto>): MutableList<FirstPrizeJodi>
}

class FirstPrizeJodiMapperImpl @Inject constructor() : FirstPrizeJodiMapper {
    override fun mapToDomainList(dtos: MutableList<FirstPrizeJodiDto>): MutableList<FirstPrizeJodi> {
        return dtos.map { it.toFirstPrizeJodi() }.toMutableList()
    }
}
