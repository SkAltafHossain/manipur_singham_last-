package com.altaf.manipursinghamlast.ui.numberCombination.viewmodel

import androidx.lifecycle.viewModelScope
import com.altaf.manipursinghamlast.common.base.BaseViewModel
import com.altaf.manipursinghamlast.domain.usecase.numberCombination.NumberCombinationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberCombinationViewModel @Inject constructor(
    private val numberCombinationUseCase: NumberCombinationUseCase
) : BaseViewModel<NumberCombinationState, NumberCombinationEvent>() {

    private val _uiState = MutableStateFlow<NumberCombinationState>(NumberCombinationState.Loading)
    val uiState: StateFlow<NumberCombinationState> = _uiState

    private val _uiEvent = MutableStateFlow<NumberCombinationEvent>(NumberCombinationEvent.Empty)
    val uiEvent: StateFlow<NumberCombinationEvent> = _uiEvent

    init {

    }

    fun onSearchQueryChanged(query: String) {
        viewModelScope.launch {
            _uiState.value = NumberCombinationState.Loading
            try {
                val data = numberCombinationUseCase(query)
                _uiState.value = if (data.isNotEmpty()) {
                    NumberCombinationState.Success(data)
                } else {
                    NumberCombinationState.Empty
                }
            } catch (e: Exception) {
                val message = e.message ?: "Unknown error"
                _uiState.value = NumberCombinationState.Error(message)
                _uiEvent.value = NumberCombinationEvent.ShowError(message)
            }
        }
    }

    fun clearEvent() {
        _uiEvent.value = NumberCombinationEvent.Empty
    }
}