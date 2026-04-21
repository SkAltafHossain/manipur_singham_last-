package com.altaf.haryanalast.ui.showResult.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.altaf.haryanalast.common.base.BaseViewModel
import com.altaf.haryanalast.common.extension.toSimpleJson
import com.altaf.haryanalast.common.result.NetworkResult
import com.altaf.haryanalast.domain.usecase.latestresultspdf.LatestResultsPdfUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowResultViewModel @Inject constructor(
    private val latestResultsPdfUseCase: LatestResultsPdfUseCase
) : BaseViewModel<ShowResultState, ShowResultEvent>() {

    private val _uiState = MutableStateFlow<ShowResultState>(ShowResultState.Loading)
    val uiState: StateFlow<ShowResultState> = _uiState

    private val _uiEvent = MutableStateFlow<ShowResultEvent>(ShowResultEvent.Empty)
    val uiEvent: StateFlow<ShowResultEvent> = _uiEvent

    init {
        fetchLatestResults()
    }

    fun fetchLatestResults() {
        _uiState.value = ShowResultState.Loading
        
        viewModelScope.launch {
            when (val result = latestResultsPdfUseCase()) {
                is NetworkResult.Success -> {
                    val results = result.data
                    Log.d("TAG", "fetchLatestResults: ${results.toSimpleJson()}")
                    _uiState.value = if (results.isNotEmpty()) {
                        ShowResultState.Success(results)
                    } else {
                        ShowResultState.Empty
                    }
                }
                is NetworkResult.Error -> {
                    _uiState.value = ShowResultState.Error(result.message ?: "An error occurred")
                    _uiEvent.value = ShowResultEvent.ShowError(result.message ?: "Failed to load results")
                }

                is NetworkResult.Loading -> {
                    _uiState.value = ShowResultState.Loading
                }
            }
        }
    }

    fun clearEvent() {
        _uiEvent.value = ShowResultEvent.Empty
    }
}
