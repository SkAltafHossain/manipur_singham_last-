package com.kerala.lastkerala.ui.firstPizeJodi.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.kerala.lastkerala.common.base.BaseViewModel
import com.kerala.lastkerala.common.extension.toSimpleJson
import com.kerala.lastkerala.common.result.NetworkResult
import com.kerala.lastkerala.domain.usecase.FirstPrizeJodiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstPrizeJodiViewModel @Inject constructor(
    private val firstPrizeJodiUseCase: FirstPrizeJodiUseCase
) : BaseViewModel<FirstPrizeJodiState, FirstPrizeJodiEvent>() {

    private val _uiState = MutableStateFlow<FirstPrizeJodiState>(FirstPrizeJodiState.Loading)
    val uiState: StateFlow<FirstPrizeJodiState> = _uiState

    private val _uiEvent = MutableStateFlow<FirstPrizeJodiEvent>(FirstPrizeJodiEvent.Empty)
    val uiEvent: StateFlow<FirstPrizeJodiEvent> = _uiEvent

    init {
        loadFirstPrizeJodi()
    }

    fun loadFirstPrizeJodi() {
        viewModelScope.launch {
            _uiState.value = FirstPrizeJodiState.Loading
            when (val result = firstPrizeJodiUseCase()) {
                is NetworkResult.Success -> {
                    Log.d("TAG", "loadFirstPrizeJodi: ${result.data.toSimpleJson()}")
                    val data = result.data
                    if (data.isNotEmpty()) {
                        _uiState.value = FirstPrizeJodiState.Success(data)
                    } else {
                        _uiState.value = FirstPrizeJodiState.Empty
                    }
                }
                is NetworkResult.Error -> {
                    _uiState.value = FirstPrizeJodiState.Error(result.message)
                    _uiEvent.value = FirstPrizeJodiEvent.ShowError(result.message)
                }
                is NetworkResult.Loading -> {
                    _uiState.value = FirstPrizeJodiState.Loading
                }
            }
        }
    }

    fun clearEvent() {
        _uiEvent.value = FirstPrizeJodiEvent.Empty
    }
}
