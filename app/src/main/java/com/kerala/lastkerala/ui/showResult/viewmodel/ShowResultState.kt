package com.kerala.lastkerala.ui.showResult.viewmodel

import com.kerala.lastkerala.domain.model.LatestResultPdf

/**
 * UI State for ShowResult screen
 */
sealed class ShowResultState {
    object Loading : ShowResultState()
    object Empty : ShowResultState()
    data class Success(val results: List<LatestResultPdf>) : ShowResultState()
    data class Error(val message: String) : ShowResultState()
}
