package com.kerala.lastkerala.domain.usecase.latestresultspdf

import com.kerala.lastkerala.common.result.NetworkResult
import com.kerala.lastkerala.domain.model.LatestResultPdf

interface LatestResultsPdfUseCase {
    suspend operator fun invoke(): NetworkResult<List<LatestResultPdf>>
}
