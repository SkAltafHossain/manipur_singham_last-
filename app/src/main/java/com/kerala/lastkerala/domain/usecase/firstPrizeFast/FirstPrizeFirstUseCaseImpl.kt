package com.kerala.lastkerala.domain.usecase.firstPrizeFast

import com.kerala.lastkerala.common.result.NetworkResult
import com.kerala.lastkerala.domain.model.FirstPrizeFirst
import com.kerala.lastkerala.domain.model.FirstPrizeJodi
import com.kerala.lastkerala.domain.repository.FirstPrizeFirstRepository
import com.kerala.lastkerala.domain.repository.FirstPrizeJodiRepository
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
