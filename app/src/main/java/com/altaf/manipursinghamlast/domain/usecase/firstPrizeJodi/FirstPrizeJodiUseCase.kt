package com.altaf.manipursinghamlast.domain.usecase.firstPrizeJodi

import com.altaf.manipursinghamlast.common.result.NetworkResult
import com.altaf.manipursinghamlast.domain.model.FirstPrizeJodi

interface FirstPrizeJodiUseCase {
    suspend operator fun invoke(): NetworkResult<List<FirstPrizeJodi>>
}
