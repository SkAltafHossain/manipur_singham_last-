package com.kerala.lastkerala.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kerala.lastkerala.BuildConfig
import com.kerala.lastkerala.domain.model.LatestResultPdf

data class LatestResultPdfItemDto(
    @SerializedName("uniqcode")
    val uniqCode: String,
    
    @SerializedName("title")
    val title: String,
    
    @SerializedName("drow_number")
    val drowNumber: String,
    
    @SerializedName("first_price")
    val firstPrice: String,
    
    @SerializedName("sce_price")
    val scePrice: String,
    
    @SerializedName("third_price")
    val thirdPrice: String,
    
    @SerializedName("for_price")
    val forPrice: String,
    
    @SerializedName("five_price")
    val fivePrice: String,
    
    @SerializedName("pdf_file")
    val pdfFile: String,
    
    @SerializedName("result_date")
    val resultDate: String,
    
    @SerializedName("result_time")
    val resultTime: String,
    
    @SerializedName("time_id")
    val timeId: String,
    
    @SerializedName("pdf_url")
    val pdfUrl: String
) {
    fun toLatestResultPdf(): LatestResultPdf {
        return LatestResultPdf(
            uniqcode = uniqCode,
            title = title,
            drowNumber = drowNumber,
            firstPrice = firstPrice,
            scePrice = scePrice,
            thirdPrice = thirdPrice,
            forPrice = forPrice,
            fivePrice = fivePrice,
            pdfFile = pdfFile,
            resultDate = resultDate,
            resultTime = resultTime,
            timeId = timeId,
            pdfUrl = BuildConfig.PDF_URL + pdfUrl
        )
    }
}