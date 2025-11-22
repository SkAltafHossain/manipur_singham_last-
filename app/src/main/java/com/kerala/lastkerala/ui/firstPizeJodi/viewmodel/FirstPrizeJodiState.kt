package com.kerala.lastkerala.ui.firstPizeJodi.viewmodel

/**
 * UI State for Home screen
 */
sealed class FirstPrizeJodiState {
    object Loading : FirstPrizeJodiState()
    object Empty : FirstPrizeJodiState()
}