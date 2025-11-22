package com.kerala.lastkerala.ui.numberCombination.viewmodel

/**
 * Sealed class for one-time events in Number Combination screen
 */
sealed class NumberCombinationEvent {
    object Empty : NumberCombinationEvent()
}
