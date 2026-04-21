package com.altaf.haryanalast.domain.mapper

import com.altaf.haryanalast.domain.model.FirstPrizeJodi
import com.altaf.haryanalast.data.remote.dto.FirstPrizeJodiDto
import javax.inject.Inject

interface FirstPrizeJodiMapper {
    fun mapToDomainList(dtos: MutableList<FirstPrizeJodiDto>): MutableList<FirstPrizeJodi>
}

class FirstPrizeJodiMapperImpl @Inject constructor() : FirstPrizeJodiMapper {
    override fun mapToDomainList(dtos: MutableList<FirstPrizeJodiDto>): MutableList<FirstPrizeJodi> {
        return dtos.map { it.toFirstPrizeJodi() }.toMutableList()
    }
}
