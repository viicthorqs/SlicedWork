package com.slicedwork.home.presentation

import com.slicedwork.domain.model.JobCategory

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(val jobCategories: List<JobCategory>) : HomeUiState()
    data class Error(val errorMessage: String) : HomeUiState()
}
