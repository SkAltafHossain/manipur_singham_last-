package com.kerala.lastkerala.ui.numberPattern.viewmodel

/**
 * UI State for Number Pattern screen
 */
sealed class NumberPatternState {
    object Loading : NumberPatternState()
    object Empty : NumberPatternState()
}
