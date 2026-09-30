package com.altaf.manipursinghamlast.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.altaf.manipursinghamlast.domain.model.FirstPrizeFirst

data class FirstPrizeFirstDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("11:00 AM")
    val time1130: String,
    @SerializedName("12:00 PM")
    val time1500: String,
    @SerializedName("04:00 PM")
    val time1700: String,
    @SerializedName("07:00 PM")
    val time2030: String,
    @SerializedName("09:00 PM")
    val time2200: String
) {
    fun toFirstPrizeFirst(): FirstPrizeFirst {
        return FirstPrizeFirst(
            date = date,
            time1130 = time1130,
            time1500 = time1500,
            time1700 = time1700,
            time2030 = time2030,
            time2200 = time2200
        )
    }
}
