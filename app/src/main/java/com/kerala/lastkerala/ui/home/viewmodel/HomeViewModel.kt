package com.kerala.lastkerala.ui.home.viewmodel


import com.kerala.lastkerala.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(


) : BaseViewModel<HomeState, HomeEvent>() {


    private val _uiState = MutableStateFlow<HomeState>(HomeState.Loading)
    val uiState: StateFlow<HomeState> = _uiState
    private val _uiEvent = MutableStateFlow<HomeEvent>(HomeEvent.Empty)
    val uiEvent: StateFlow<HomeEvent> = _uiEvent

    fun onCardClick(cardType: String) {
        when (cardType) {
            "LastJodiNumber" -> _uiEvent.value = HomeEvent.LastJodiNumberClick
            "LastNumber" -> _uiEvent.value = HomeEvent.LastNumberClick
            "NumberCombination" -> _uiEvent.value = HomeEvent.NumberCombinationClick
            "ShowResult" -> _uiEvent.value = HomeEvent.ShowResultClick
        }
    }


    fun onShareAppClick() {
        _uiEvent.value = HomeEvent.ShareAppClick
    }


    fun clearEvent() {
        _uiEvent.value = HomeEvent.Empty
    }
}

