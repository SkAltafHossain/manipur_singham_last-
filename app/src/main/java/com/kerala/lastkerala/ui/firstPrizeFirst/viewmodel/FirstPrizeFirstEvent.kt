package com.altaf.haryanalast.ui.firstPrizeFirst.viewmodel

import com.altaf.haryanalast.ui.firstPizeJodi.viewmodel.FirstPrizeJodiEvent

// Sealed class for one-time events in First Prize First screen
sealed class FirstPrizeFirstEvent {
    object Empty : FirstPrizeFirstEvent()
    data class ShowError(val message: String) : FirstPrizeFirstEvent()
}
