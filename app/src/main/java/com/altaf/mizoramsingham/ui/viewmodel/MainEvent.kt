package com.altaf.manipursingham.ui.viewmodel

sealed class MainEvent {
    object ShowToast : MainEvent()
    object NavigateToNextScreen : MainEvent()
}