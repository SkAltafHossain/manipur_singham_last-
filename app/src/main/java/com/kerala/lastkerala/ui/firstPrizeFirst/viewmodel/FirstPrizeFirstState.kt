package com.kerala.lastkerala.ui.firstPrizeFirst.viewmodel

/**
 * UI State for First Prize First screen
 */
sealed class FirstPrizeFirstState {
    object Loading : FirstPrizeFirstState()
    object Empty : FirstPrizeFirstState()
}
