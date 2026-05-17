package com.slicedwork.joblist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.domain.usecase.GetJobsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class JobListViewModel(private val getJobsUseCase: GetJobsUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<JobListUiState> =
        MutableStateFlow(JobListUiState.Loading)
    val uiState: StateFlow<JobListUiState> get() = _uiState

    private val _effect = MutableSharedFlow<JobListEffect>()
    val effect = _effect.asSharedFlow()

    fun onIntent(intent: JobListIntent) = when (intent) {
        is JobListIntent.LoadJobs -> loadJobs(intent.jobCategory)
        is JobListIntent.JobClicked -> navigateToJobDetails(intent)
    }

    private fun loadJobs(jobCategory: JobCategory) {
        viewModelScope.launch {
            _uiState.update { JobListUiState.Loading }
            delay(1000)
            runCatching { getJobsUseCase(jobCategory) }
                .onSuccess { jobs ->
                    _uiState.update { JobListUiState.Success(jobs = jobs) }
                }.onFailure { error ->
                    _uiState.update { JobListUiState.Error(error.message.toString()) }
                }
        }
    }

    private fun navigateToJobDetails(intent: JobListIntent.JobClicked) {
        viewModelScope.launch {
            _effect.emit(JobListEffect.NavigateToJobDetails(intent.jobId))
        }
    }
}
