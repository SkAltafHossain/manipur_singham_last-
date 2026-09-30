package com.altaf.manipursinghamlast.ui.numberCombination.viewmodel

/**
 * UI State for Number Combination screen
 */
sealed class NumberCombinationState {
    object Loading : NumberCombinationState()
    data class Success(val data: List<String>) : NumberCombinationState()
    data class Error(val message: String) : NumberCombinationState()
    object Empty : NumberCombinationState()
}
