package com.kerala.lastkerala.domain.usecase.firstPrizeFast

import com.kerala.lastkerala.common.result.NetworkResult
import com.kerala.lastkerala.domain.model.FirstPrizeFirst

interface FirstPrizeFirstUseCase {
    suspend operator fun invoke(): NetworkResult<List<FirstPrizeFirst>>
}
