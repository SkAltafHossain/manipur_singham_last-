package com.kerala.lastkerala.domain.mapper

import com.kerala.lastkerala.data.remote.dto.FirstPrizeFirstDto
import com.kerala.lastkerala.domain.model.FirstPrizeFirst
import javax.inject.Inject

interface FirstPrizeFirstMapper {
    fun mapToDomainList(dtos: List<FirstPrizeFirstDto>): MutableList<FirstPrizeFirst>
}

class FirstPrizeFirstMapperImpl @Inject constructor() : FirstPrizeFirstMapper {
    override fun mapToDomainList(dtos: List<FirstPrizeFirstDto>): MutableList<FirstPrizeFirst> {
        return dtos.map { it.toFirstPrizeFirst() }.toMutableList()
    }
}
