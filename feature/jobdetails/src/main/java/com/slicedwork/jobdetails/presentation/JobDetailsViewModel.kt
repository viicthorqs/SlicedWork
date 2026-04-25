package com.slicedwork.jobdetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slicedwork.domain.usecase.GetJobUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class JobDetailsViewModel(private val getJobUseCase: GetJobUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<JobDetailsUiState> =
        MutableStateFlow(JobDetailsUiState.Loading)
    val uiState: StateFlow<JobDetailsUiState> get() = _uiState

    fun onIntent(intent: JobDetailsIntent) = when (intent) {
        is JobDetailsIntent.LoadJob -> loadJob(intent.jobId)
    }

    private fun loadJob(jobId: String) = viewModelScope.launch {
        delay(2000)
        runCatching { getJobUseCase(jobId = jobId) }
            .onSuccess { job ->
                _uiState.update {
                    job?.let { JobDetailsUiState.Success(job = job) }
                        ?: JobDetailsUiState.Error("Job has not been founded!")
                }
            }.onFailure { error ->
                _uiState.update { JobDetailsUiState.Error(error.message.toString()) }
            }
    }
}
