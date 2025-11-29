package com.kerala.lastkerala.domain.repository

import com.kerala.lastkerala.domain.model.LatestResultPdf

interface LatestResultsPdfRepository {
    suspend fun getLatestResultsPdf(): List<LatestResultPdf>
}
