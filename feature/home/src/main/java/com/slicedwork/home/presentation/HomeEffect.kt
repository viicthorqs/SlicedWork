package com.slicedwork.home.presentation

sealed interface HomeEffect {
    data class NavigateToJobDetails(val jobId: String) : HomeEffect
}