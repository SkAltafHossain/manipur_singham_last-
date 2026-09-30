package com.altaf.manipursinghamlast.ui.viewmodel

sealed class MainEvent {
    object ShowToast : MainEvent()
    object NavigateToNextScreen : MainEvent()
}