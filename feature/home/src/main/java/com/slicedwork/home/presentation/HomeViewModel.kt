package com.slicedwork.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slicedwork.domain.usecase.GetJobsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val getJobsUseCase: GetJobsUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> get() = _uiState

    fun intent(intent: HomeIntent) = when (intent) {
        HomeIntent.LoadJobs -> loadJobs()
    }

    private fun loadJobs() = viewModelScope.launch {
        delay(2000)
        runCatching { getJobsUseCase() }
            .onSuccess { jobs ->
                _uiState.update { HomeUiState.Success(jobs = jobs) }
            }.onFailure { error ->
                _uiState.update { HomeUiState.Error(error.message.toString()) }
            }
    }
}
