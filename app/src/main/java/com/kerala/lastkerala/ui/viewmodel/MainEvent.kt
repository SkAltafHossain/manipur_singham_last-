package com.altaf.haryanalast.ui.viewmodel

sealed class MainEvent {
    object ShowToast : MainEvent()
    object NavigateToNextScreen : MainEvent()
}