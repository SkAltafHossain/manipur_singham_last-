package com.kerala.lastkerala.ui.numberPattern.viewmodel

import com.kerala.lastkerala.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NumberPatternViewModel @Inject constructor(

) : BaseViewModel<NumberPatternState, NumberPatternEvent>() {

    private val _uiState = MutableStateFlow<NumberPatternState>(NumberPatternState.Loading)
    val uiState: StateFlow<NumberPatternState> = _uiState

    private val _uiEvent = MutableStateFlow<NumberPatternEvent>(NumberPatternEvent.Empty)
    val uiEvent: StateFlow<NumberPatternEvent> = _uiEvent

    fun clearEvent() {
        _uiEvent.value = NumberPatternEvent.Empty
    }
}
