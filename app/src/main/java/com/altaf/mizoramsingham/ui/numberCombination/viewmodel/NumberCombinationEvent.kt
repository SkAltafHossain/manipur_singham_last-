package com.altaf.manipursinghamlast.ui.numberCombination.viewmodel

/**
 * Sealed class for one-time events in Number Combination screen
 */
sealed class NumberCombinationEvent {
    object Empty : NumberCombinationEvent()
    data class ShowError(val message: String) : NumberCombinationEvent()
}
