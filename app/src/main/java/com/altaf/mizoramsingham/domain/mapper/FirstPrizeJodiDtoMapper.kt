package com.altaf.manipursingham.domain.mapper

import com.altaf.manipursingham.domain.model.FirstPrizeJodi
import com.altaf.manipursingham.data.remote.dto.FirstPrizeJodiDto
import javax.inject.Inject

interface FirstPrizeJodiMapper {
    fun mapToDomainList(dtos: MutableList<FirstPrizeJodiDto>): MutableList<FirstPrizeJodi>
}

class FirstPrizeJodiMapperImpl @Inject constructor() : FirstPrizeJodiMapper {
    override fun mapToDomainList(dtos: MutableList<FirstPrizeJodiDto>): MutableList<FirstPrizeJodi> {
        return dtos.map { it.toFirstPrizeJodi() }.toMutableList()
    }
}
