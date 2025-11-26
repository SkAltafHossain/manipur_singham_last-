package com.kerala.lastkerala.domain.usecase.firstPrizeJodi

import com.kerala.lastkerala.common.result.NetworkResult
import com.kerala.lastkerala.domain.model.FirstPrizeJodi

interface FirstPrizeJodiUseCase {
    suspend operator fun invoke(): NetworkResult<List<FirstPrizeJodi>>
}
