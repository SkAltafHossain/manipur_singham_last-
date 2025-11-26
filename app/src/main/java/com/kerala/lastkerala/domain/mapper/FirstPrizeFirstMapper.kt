package com.kerala.lastkerala.domain.mapper

import com.kerala.lastkerala.data.remote.model.FirstPrizeFirstResponse
import com.kerala.lastkerala.domain.model.FirstPrizeFirst
import javax.inject.Inject

class FirstPrizeFirstMapper @Inject constructor() {
    fun mapToDomainList(apiResponse: List<Map<String, String>>): MutableList<FirstPrizeFirst> {
        return apiResponse.map { item ->
            FirstPrizeFirst(
                date = item["date"] ?: "",
                time1130 = item["11:30 AM"] ?: "",
                time1500 = item["03:00 PM"] ?: "",
                time1700 = item["05:00 PM"] ?: "",
                time2030 = item["08:30 PM"] ?: ""
            )
        }.toMutableList()
    }
}
