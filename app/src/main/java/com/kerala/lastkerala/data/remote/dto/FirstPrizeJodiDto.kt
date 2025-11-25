package com.kerala.lastkerala.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kerala.lastkerala.domain.model.FirstPrizeJodi

data class FirstPrizeJodiDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("11:30 AM")
    val time1130: String,
    @SerializedName("03:00 PM")
    val time1500: String,
    @SerializedName("05:00 PM")
    val time1700: String,
    @SerializedName("08:30 PM")
    val time2030: String
) {
    fun toFirstPrizeJodi(): FirstPrizeJodi {

        return FirstPrizeJodi(
            date = date,
            time1130 = time1130,
            time1500 = time1500,
            time1700 = time1700,
            time2030 = time2030
        )
    }
}