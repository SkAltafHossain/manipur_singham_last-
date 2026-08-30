package com.altaf.manipursingham.ui.firstPrizeFirst.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.altaf.manipursingham.common.base.BaseViewModel
import com.altaf.manipursingham.common.extension.toSimpleJson
import com.altaf.manipursingham.common.result.NetworkResult
import com.altaf.manipursingham.domain.usecase.firstPrizeFast.FirstPrizeFirstUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstPrizeFirstViewModel @Inject constructor(
    private val firstPrizeFirstUseCase: FirstPrizeFirstUseCase
) : BaseViewModel<FirstPrizeFirstState, FirstPrizeFirstEvent>() {

    private val _uiState = MutableStateFlow<FirstPrizeFirstState>(FirstPrizeFirstState.Loading)
    val uiState: StateFlow<FirstPrizeFirstState> = _uiState

    private val _uiEvent = MutableStateFlow<FirstPrizeFirstEvent>(FirstPrizeFirstEvent.Empty)
    val uiEvent: StateFlow<FirstPrizeFirstEvent> = _uiEvent

    init {
        loadFirstPrizeFast()
    }

    fun loadFirstPrizeFast() {
        viewModelScope.launch {
            _uiState.value = FirstPrizeFirstState.Loading
            when (val result = firstPrizeFirstUseCase()) {
                is NetworkResult.Success -> {
                    Log.d("TAG", "loadFirstPrizeJodi: ${result.data.toSimpleJson()}")
                    val data = result.data
                    if (data.isNotEmpty()) {
                        _uiState.value = FirstPrizeFirstState.Success(data)
                    } else {
                        _uiState.value = FirstPrizeFirstState.Empty
                    }
                }
                is NetworkResult.Error -> {
                    _uiState.value = FirstPrizeFirstState.Error(result.message)
                    _uiEvent.value = FirstPrizeFirstEvent.ShowError(result.message)
                }
                is NetworkResult.Loading -> {
                    _uiState.value = FirstPrizeFirstState.Loading
                }
            }
        }
    }

    fun clearEvent() {
        _uiEvent.value = FirstPrizeFirstEvent.Empty
    }
}
