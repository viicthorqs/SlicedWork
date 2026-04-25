package com.slicedwork.home.presentation

sealed class HomeIntent {
    data object LoadJobs : HomeIntent()
    data class JobClicked(val jobId: String) : HomeIntent()
}
