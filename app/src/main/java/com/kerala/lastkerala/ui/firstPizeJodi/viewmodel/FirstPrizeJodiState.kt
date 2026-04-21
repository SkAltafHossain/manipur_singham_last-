package com.altaf.haryanalast.ui.firstPizeJodi.viewmodel

import com.altaf.haryanalast.domain.model.FirstPrizeJodi

/**
 * UI State for First Prize Jodi screen
 */
sealed class FirstPrizeJodiState {
    object Loading : FirstPrizeJodiState()
    object Empty : FirstPrizeJodiState()
    data class Success(val data: List<FirstPrizeJodi>) : FirstPrizeJodiState()
    data class Error(val message: String) : FirstPrizeJodiState()
}