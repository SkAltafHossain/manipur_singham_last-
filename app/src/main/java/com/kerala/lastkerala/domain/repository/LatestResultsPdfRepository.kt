package com.altaf.haryanalast.domain.repository

import com.altaf.haryanalast.domain.model.LatestResultPdf

interface LatestResultsPdfRepository {
    suspend fun getLatestResultsPdf(): List<LatestResultPdf>
}
