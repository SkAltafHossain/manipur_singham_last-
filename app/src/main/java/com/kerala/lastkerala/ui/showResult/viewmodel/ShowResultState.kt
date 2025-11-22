package com.kerala.lastkerala.ui.showResult.viewmodel

/**
 * UI State for ShowResult screen
 */
sealed class ShowResultState {
    object Loading : ShowResultState()
    object Empty : ShowResultState()
}
