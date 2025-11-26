package com.kerala.lastkerala.ui.firstPrizeFirst.viewmodel

import com.kerala.lastkerala.domain.model.FirstPrizeFirst

/**
 * UI State for First Prize First screen
 */
sealed class FirstPrizeFirstState {
    object Loading : FirstPrizeFirstState()
    object Empty : FirstPrizeFirstState()
    data class Success(val data: List<FirstPrizeFirst>) : FirstPrizeFirstState()
    data class Error(val message: String) : FirstPrizeFirstState()
}
