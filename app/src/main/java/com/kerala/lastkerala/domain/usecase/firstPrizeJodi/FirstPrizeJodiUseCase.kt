package com.altaf.haryanalast.domain.usecase.firstPrizeJodi

import com.altaf.haryanalast.common.result.NetworkResult
import com.altaf.haryanalast.domain.model.FirstPrizeJodi

interface FirstPrizeJodiUseCase {
    suspend operator fun invoke(): NetworkResult<List<FirstPrizeJodi>>
}
