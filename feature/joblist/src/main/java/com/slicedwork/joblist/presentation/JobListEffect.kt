package com.slicedwork.joblist.presentation

sealed interface JobListEffect {
    data class NavigateToJobDetails(val jobId: String) : JobListEffect
}