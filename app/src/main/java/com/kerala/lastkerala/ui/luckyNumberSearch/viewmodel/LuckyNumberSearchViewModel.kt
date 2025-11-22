package com.kerala.lastkerala.ui.luckyNumberSearch.viewmodel

import com.kerala.lastkerala.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LuckyNumberSearchViewModel @Inject constructor() : 
    BaseViewModel<LuckyNumberSearchState, LuckyNumberSearchEvent>() {

    private val _uiState = MutableStateFlow<LuckyNumberSearchState>(LuckyNumberSearchState.Loading)
    val uiState: StateFlow<LuckyNumberSearchState> = _uiState

    private val _uiEvent = MutableStateFlow<LuckyNumberSearchEvent>(LuckyNumberSearchEvent.Empty)
    val uiEvent: StateFlow<LuckyNumberSearchEvent> = _uiEvent

    fun clearEvent() {
        _uiEvent.value = LuckyNumberSearchEvent.Empty
    }
}
