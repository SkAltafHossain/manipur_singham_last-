package com.altaf.manipursinghamlast.domain.usecase.firstPrizeFast

import com.altaf.manipursinghamlast.common.result.NetworkResult
import com.altaf.manipursinghamlast.domain.model.FirstPrizeFirst

interface FirstPrizeFirstUseCase {
    suspend operator fun invoke(): NetworkResult<List<FirstPrizeFirst>>
}
