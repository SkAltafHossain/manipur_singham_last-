package com.kerala.lastkerala.domain.model

data class LatestResultPdf(
    val uniqcode: String,
    val title: String,
    val drowNumber: String,
    val firstPrice: String,
    val scePrice: String,
    val thirdPrice: String,
    val forPrice: String,
    val fivePrice: String,
    val pdfFile: String,
    val resultDate: String,
    val resultTime: String,
    val timeId: String,
    val pdfUrl: String
)
