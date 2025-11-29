package com.kerala.lastkerala.domain.usecase.latestresultspdf

import com.kerala.lastkerala.common.result.NetworkResult
import com.kerala.lastkerala.domain.model.LatestResultPdf
import com.kerala.lastkerala.domain.repository.LatestResultsPdfRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LatestResultsPdfUseCaseImpl @Inject constructor(
    private val repository: LatestResultsPdfRepository
) : LatestResultsPdfUseCase {
    
    override suspend operator fun invoke(): NetworkResult<List<LatestResultPdf>> {
        return try {
            val result = repository.getLatestResultsPdf()
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
