package com.kerala.lastkerala.ui.home.viewmodel


// Sealed class for one-time events in Home screen
sealed class HomeEvent {
    object Empty : HomeEvent()
}
