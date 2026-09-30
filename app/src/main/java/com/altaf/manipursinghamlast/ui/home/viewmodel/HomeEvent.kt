package com.altaf.manipursinghamlast.ui.home.viewmodel


sealed class HomeEvent {
    object Empty : HomeEvent()
    object LastJodiNumberClick : HomeEvent()
    object LastNumberClick : HomeEvent()
    object NumberCombinationClick : HomeEvent()
    object ShowResultClick : HomeEvent()
    object ShareAppClick : HomeEvent()
}

