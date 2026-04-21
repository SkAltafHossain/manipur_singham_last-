package com.altaf.haryanalast.domain.mapper

import com.altaf.haryanalast.data.remote.dto.FirstPrizeFirstDto
import com.altaf.haryanalast.domain.model.FirstPrizeFirst
import javax.inject.Inject

interface FirstPrizeFirstMapper {
    fun mapToDomainList(dtos: List<FirstPrizeFirstDto>): MutableList<FirstPrizeFirst>
}

class FirstPrizeFirstMapperImpl @Inject constructor() : FirstPrizeFirstMapper {
    override fun mapToDomainList(dtos: List<FirstPrizeFirstDto>): MutableList<FirstPrizeFirst> {
        return dtos.map { it.toFirstPrizeFirst() }.toMutableList()
    }
}
