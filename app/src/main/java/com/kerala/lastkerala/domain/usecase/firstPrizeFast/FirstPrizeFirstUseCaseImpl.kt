package com.altaf.haryanalast.domain.usecase.firstPrizeFast

import com.altaf.haryanalast.common.result.NetworkResult
import com.altaf.haryanalast.domain.model.FirstPrizeFirst
import com.altaf.haryanalast.domain.model.FirstPrizeJodi
import com.altaf.haryanalast.domain.repository.FirstPrizeFirstRepository
import com.altaf.haryanalast.domain.repository.FirstPrizeJodiRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirstPrizeFirstUseCaseImpl @Inject constructor(
    private val repository: FirstPrizeFirstRepository
) : FirstPrizeFirstUseCase {
    
    override suspend operator fun invoke(): NetworkResult<List<FirstPrizeFirst>> {
        return try {
            val result = repository.getFirstPrizeFirst()
            if (result.isNotEmpty()) {
                NetworkResult.Success(result)
            } else {
                NetworkResult.Error("No data available")
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "An unknown error occurred")
        }
    }
}
