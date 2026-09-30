package com.altaf.manipursinghamlast.domain.repository

import com.altaf.manipursinghamlast.domain.model.LatestResultPdf

interface LatestResultsPdfRepository {
    suspend fun getLatestResultsPdf(): List<LatestResultPdf>
}
