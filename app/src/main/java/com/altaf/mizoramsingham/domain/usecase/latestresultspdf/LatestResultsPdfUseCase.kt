package com.altaf.manipursinghamlast.domain.usecase.latestresultspdf

import com.altaf.manipursinghamlast.common.result.NetworkResult
import com.altaf.manipursinghamlast.domain.model.LatestResultPdf

interface LatestResultsPdfUseCase {
    suspend operator fun invoke(): NetworkResult<List<LatestResultPdf>>
}
