package com.kerala.lastkerala.ui.firstPizeJodi.viewmodel

import com.kerala.lastkerala.common.base.BaseViewModel
import com.kerala.lastkerala.ui.home.viewmodel.HomeEvent
import com.kerala.lastkerala.ui.home.viewmodel.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.kerala.lastkerala.ui.firstPizeJodi.viewmodel.FirstPrizeJodiState
import com.kerala.lastkerala.ui.firstPizeJodi.viewmodel.FirstPrizeJodiEvent

@HiltViewModel
class FirstPrizeJodiViewModel @Inject constructor(

) : BaseViewModel<FirstPrizeJodiState, FirstPrizeJodiEvent>() {

    private val _uiState = MutableStateFlow<FirstPrizeJodiState>(FirstPrizeJodiState.Loading)
    val uiState: StateFlow<FirstPrizeJodiState> = _uiState

    private val _uiEvent = MutableStateFlow<FirstPrizeJodiEvent>(FirstPrizeJodiEvent.Empty)
    val uiEvent: StateFlow<FirstPrizeJodiEvent> = _uiEvent



    fun clearEvent() {
        _uiEvent.value = FirstPrizeJodiEvent.Empty
    }
}
