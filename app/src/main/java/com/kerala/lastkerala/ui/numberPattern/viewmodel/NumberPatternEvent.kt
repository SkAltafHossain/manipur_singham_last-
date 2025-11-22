package com.kerala.lastkerala.ui.numberPattern.viewmodel

/**
 * Sealed class for one-time events in Number Pattern screen
 */
sealed class NumberPatternEvent {
    object Empty : NumberPatternEvent()
}
