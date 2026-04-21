package com.altaf.haryanalast.domain.usecase.firstPrizeJodi

import com.altaf.haryanalast.common.result.NetworkResult
import com.altaf.haryanalast.domain.model.FirstPrizeJodi
import com.altaf.haryanalast.domain.repository.FirstPrizeJodiRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirstPrizeJodiUseCaseImpl @Inject constructor(
    private val repository: FirstPrizeJodiRepository
) : FirstPrizeJodiUseCase {
    
    override suspend operator fun invoke(): NetworkResult<List<FirstPrizeJodi>> {
        return try {
            val result = repository.getFirstPrizeJodi()
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
