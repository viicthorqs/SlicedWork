package com.slicedwork.joblist.presentation

import com.slicedwork.domain.model.Job

sealed class JobListUiState {
    data object Loading : JobListUiState()
    data class Success(val jobs: List<Job>) : JobListUiState()
    data class Error(val errorMessage: String) : JobListUiState()
}