package com.slicedwork.home.presentation

import com.slicedwork.domain.model.Job

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(val jobs: List<Job>) : HomeUiState()
    data class Error(val errorMessage: String) : HomeUiState()
}
