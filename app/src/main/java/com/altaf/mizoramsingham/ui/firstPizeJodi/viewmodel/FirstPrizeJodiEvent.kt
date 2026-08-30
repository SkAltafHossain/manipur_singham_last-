package com.altaf.manipursingham.ui.firstPizeJodi.viewmodel

/**
 * Sealed class for one-time events in First Prize Jodi screen
 */
sealed class FirstPrizeJodiEvent {
    object Empty : FirstPrizeJodiEvent()
    data class ShowError(val message: String) : FirstPrizeJodiEvent()
}
