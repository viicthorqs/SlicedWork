package com.slicedwork.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slicedwork.domain.usecase.GetJobCategoriesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val getJobCategoriesUseCase: GetJobCategoriesUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> get() = _uiState

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect = _effect.asSharedFlow()

    fun onIntent(intent: HomeIntent) = when (intent) {
        HomeIntent.LoadJobCategories -> loadJobCategories()
        is HomeIntent.JobCategoryClicked -> {
            viewModelScope.launch {
                _effect.emit(HomeEffect.NavigateToJobList(intent.jobCategory))
            }
        }
    }

    private fun loadJobCategories() = viewModelScope.launch {
        _uiState.update { HomeUiState.Loading }
        delay(1000)
        runCatching { getJobCategoriesUseCase() }
            .onSuccess { jobCategories ->
                _uiState.update { HomeUiState.Success(jobCategories = jobCategories) }
            }.onFailure { error ->
                _uiState.update { HomeUiState.Error(error.message.toString()) }
            }
    }
}
