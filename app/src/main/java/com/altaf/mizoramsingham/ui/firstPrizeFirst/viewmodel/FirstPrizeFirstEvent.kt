package com.altaf.manipursingham.ui.firstPrizeFirst.viewmodel

// Sealed class for one-time events in First Prize First screen
sealed class FirstPrizeFirstEvent {
    object Empty : FirstPrizeFirstEvent()
    data class ShowError(val message: String) : FirstPrizeFirstEvent()
}
