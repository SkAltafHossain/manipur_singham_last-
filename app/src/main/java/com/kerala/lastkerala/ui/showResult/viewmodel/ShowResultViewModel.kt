package com.kerala.lastkerala.ui.showResult.viewmodel

import com.kerala.lastkerala.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ShowResultViewModel @Inject constructor(

) : BaseViewModel<ShowResultState, ShowResultEvent>() {

    private val _uiState = MutableStateFlow<ShowResultState>(ShowResultState.Loading)
    val uiState: StateFlow<ShowResultState> = _uiState

    private val _uiEvent = MutableStateFlow<ShowResultEvent>(ShowResultEvent.Empty)
    val uiEvent: StateFlow<ShowResultEvent> = _uiEvent

    fun clearEvent() {
        _uiEvent.value = ShowResultEvent.Empty
    }
}
