package com.altaf.haryanalast.domain.usecase.firstPrizeFast

import com.altaf.haryanalast.common.result.NetworkResult
import com.altaf.haryanalast.domain.model.FirstPrizeFirst

interface FirstPrizeFirstUseCase {
    suspend operator fun invoke(): NetworkResult<List<FirstPrizeFirst>>
}
