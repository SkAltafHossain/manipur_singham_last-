package com.altaf.haryanalast.domain.usecase.latestresultspdf

import com.altaf.haryanalast.common.result.NetworkResult
import com.altaf.haryanalast.domain.model.LatestResultPdf

interface LatestResultsPdfUseCase {
    suspend operator fun invoke(): NetworkResult<List<LatestResultPdf>>
}
