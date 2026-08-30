package com.altaf.manipursingham.domain.usecase.firstPrizeFast

import com.altaf.manipursingham.common.result.NetworkResult
import com.altaf.manipursingham.domain.model.FirstPrizeFirst

interface FirstPrizeFirstUseCase {
    suspend operator fun invoke(): NetworkResult<List<FirstPrizeFirst>>
}
