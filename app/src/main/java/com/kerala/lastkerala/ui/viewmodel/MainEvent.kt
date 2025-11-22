package com.kerala.lastkerala.ui.viewmodel

sealed class MainEvent {
    object ShowToast : MainEvent()
    object NavigateToNextScreen : MainEvent()
}