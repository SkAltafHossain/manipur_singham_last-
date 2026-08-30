package com.altaf.manipursingham.domain.mapper

import com.altaf.manipursingham.data.remote.dto.FirstPrizeFirstDto
import com.altaf.manipursingham.domain.model.FirstPrizeFirst
import javax.inject.Inject

interface FirstPrizeFirstMapper {
    fun mapToDomainList(dtos: List<FirstPrizeFirstDto>): MutableList<FirstPrizeFirst>
}

class FirstPrizeFirstMapperImpl @Inject constructor() : FirstPrizeFirstMapper {
    override fun mapToDomainList(dtos: List<FirstPrizeFirstDto>): MutableList<FirstPrizeFirst> {
        return dtos.map { it.toFirstPrizeFirst() }.toMutableList()
    }
}
