package com.kerala.lastkerala.ui.home.viewmodel

/**
 * UI State for Home screen
 */
sealed class HomeState {
    object Loading : HomeState()
    object Empty : HomeState()
}