package com.kerala.lastkerala.domain.usecase

import com.kerala.lastkerala.common.result.NetworkResult
import com.kerala.lastkerala.domain.model.FirstPrizeJodi
import com.kerala.lastkerala.domain.repository.FirstPrizeJodiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
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
