package com.kerala.lastkerala.ui.numberCombination.viewmodel

/**
 * UI State for Number Combination screen
 */
sealed class NumberCombinationState {
    object Loading : NumberCombinationState()
    object Empty : NumberCombinationState()
}
