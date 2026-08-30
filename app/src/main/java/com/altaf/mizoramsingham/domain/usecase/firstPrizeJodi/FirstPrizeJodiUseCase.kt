package com.altaf.manipursingham.domain.usecase.firstPrizeJodi

import com.altaf.manipursingham.common.result.NetworkResult
import com.altaf.manipursingham.domain.model.FirstPrizeJodi

interface FirstPrizeJodiUseCase {
    suspend operator fun invoke(): NetworkResult<List<FirstPrizeJodi>>
}
