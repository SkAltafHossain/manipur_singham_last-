package com.kerala.lastkerala.ui.firstPrizeFirst.viewmodel

import com.kerala.lastkerala.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FirstPrizeFirstViewModel @Inject constructor() : 
    BaseViewModel<FirstPrizeFirstState, FirstPrizeFirstEvent>() {

    private val _uiState = MutableStateFlow<FirstPrizeFirstState>(FirstPrizeFirstState.Loading)
    val uiState: StateFlow<FirstPrizeFirstState> = _uiState

    private val _uiEvent = MutableStateFlow<FirstPrizeFirstEvent>(FirstPrizeFirstEvent.Empty)
    val uiEvent: StateFlow<FirstPrizeFirstEvent> = _uiEvent

    fun clearEvent() {
        _uiEvent.value = FirstPrizeFirstEvent.Empty
    }
}
