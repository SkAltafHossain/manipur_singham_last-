package com.altaf.manipursinghamlast.domain.mapper

import com.altaf.manipursinghamlast.data.remote.dto.FirstPrizeFirstDto
import com.altaf.manipursinghamlast.domain.model.FirstPrizeFirst
import javax.inject.Inject

interface FirstPrizeFirstMapper {
    fun mapToDomainList(dtos: List<FirstPrizeFirstDto>): MutableList<FirstPrizeFirst>
}

class FirstPrizeFirstMapperImpl @Inject constructor() : FirstPrizeFirstMapper {
    override fun mapToDomainList(dtos: List<FirstPrizeFirstDto>): MutableList<FirstPrizeFirst> {
        return dtos.map { it.toFirstPrizeFirst() }.toMutableList()
    }
}
