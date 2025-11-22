package com.kerala.lastkerala.ui.numberCombination.viewmodel

import com.kerala.lastkerala.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NumberCombinationViewModel @Inject constructor(

) : BaseViewModel<NumberCombinationState, NumberCombinationEvent>() {

    private val _uiState = MutableStateFlow<NumberCombinationState>(NumberCombinationState.Loading)
    val uiState: StateFlow<NumberCombinationState> = _uiState

    private val _uiEvent = MutableStateFlow<NumberCombinationEvent>(NumberCombinationEvent.Empty)
    val uiEvent: StateFlow<NumberCombinationEvent> = _uiEvent

    fun clearEvent() {
        _uiEvent.value = NumberCombinationEvent.Empty
    }
}
