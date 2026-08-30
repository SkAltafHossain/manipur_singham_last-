package com.altaf.manipursingham.domain.repository

import com.altaf.manipursingham.domain.model.LatestResultPdf

interface LatestResultsPdfRepository {
    suspend fun getLatestResultsPdf(): List<LatestResultPdf>
}
