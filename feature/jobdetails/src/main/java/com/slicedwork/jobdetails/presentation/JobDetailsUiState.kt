package com.slicedwork.jobdetails.presentation

import com.slicedwork.domain.model.Job

sealed class JobDetailsUiState {
    data object Loading : JobDetailsUiState()
    data class Success(val job: Job) : JobDetailsUiState()
    data class Error(val errorMessage: String) : JobDetailsUiState()
}