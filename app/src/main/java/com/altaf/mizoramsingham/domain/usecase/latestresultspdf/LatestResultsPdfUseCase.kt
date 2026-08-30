package com.altaf.manipursingham.domain.usecase.latestresultspdf

import com.altaf.manipursingham.common.result.NetworkResult
import com.altaf.manipursingham.domain.model.LatestResultPdf

interface LatestResultsPdfUseCase {
    suspend operator fun invoke(): NetworkResult<List<LatestResultPdf>>
}
