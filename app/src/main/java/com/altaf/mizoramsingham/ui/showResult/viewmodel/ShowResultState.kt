package com.altaf.manipursinghamlast.ui.showResult.viewmodel

import com.altaf.manipursinghamlast.domain.model.LatestResultPdf

/**
 * UI State for ShowResult screen
 */
sealed class ShowResultState {
    object Loading : ShowResultState()
    object Empty : ShowResultState()
    data class Success(val results: List<LatestResultPdf>) : ShowResultState()
    data class Error(val message: String) : ShowResultState()
}
