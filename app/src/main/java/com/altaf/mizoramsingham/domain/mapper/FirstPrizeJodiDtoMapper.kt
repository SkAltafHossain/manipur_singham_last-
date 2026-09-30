package com.altaf.manipursinghamlast.domain.mapper

import com.altaf.manipursinghamlast.domain.model.FirstPrizeJodi
import com.altaf.manipursinghamlast.data.remote.dto.FirstPrizeJodiDto
import javax.inject.Inject

interface FirstPrizeJodiMapper {
    fun mapToDomainList(dtos: MutableList<FirstPrizeJodiDto>): MutableList<FirstPrizeJodi>
}

class FirstPrizeJodiMapperImpl @Inject constructor() : FirstPrizeJodiMapper {
    override fun mapToDomainList(dtos: MutableList<FirstPrizeJodiDto>): MutableList<FirstPrizeJodi> {
        return dtos.map { it.toFirstPrizeJodi() }.toMutableList()
    }
}
