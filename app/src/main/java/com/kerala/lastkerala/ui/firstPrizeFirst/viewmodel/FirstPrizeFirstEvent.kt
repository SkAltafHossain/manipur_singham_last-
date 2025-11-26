package com.kerala.lastkerala.ui.firstPrizeFirst.viewmodel

import com.kerala.lastkerala.ui.firstPizeJodi.viewmodel.FirstPrizeJodiEvent

// Sealed class for one-time events in First Prize First screen
sealed class FirstPrizeFirstEvent {
    object Empty : FirstPrizeFirstEvent()
    data class ShowError(val message: String) : FirstPrizeFirstEvent()
}
