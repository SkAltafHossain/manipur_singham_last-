package com.kerala.lastkerala.ui.luckyNumberSearch.viewmodel

/**
 * UI State for Lucky Number Search screen
 */
sealed class LuckyNumberSearchState {
    object Loading : LuckyNumberSearchState()
    object Empty : LuckyNumberSearchState()
}
