package com.altaf.haryanalast.ui.showResult.viewmodel

import com.altaf.haryanalast.domain.model.LatestResultPdf

/**
 * UI State for ShowResult screen
 */
sealed class ShowResultState {
    object Loading : ShowResultState()
    object Empty : ShowResultState()
    data class Success(val results: List<LatestResultPdf>) : ShowResultState()
    data class Error(val message: String) : ShowResultState()
}
