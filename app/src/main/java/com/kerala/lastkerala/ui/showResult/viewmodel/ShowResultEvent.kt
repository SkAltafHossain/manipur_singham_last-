package com.kerala.lastkerala.ui.showResult.viewmodel

// Sealed class for one-time events in ShowResult screen
sealed class ShowResultEvent {
    object Empty : ShowResultEvent()
}
