package com.slicedwork.slicedwork

sealed interface SlicedWorkRoute {
    data object Home : SlicedWorkRoute
    data class JobDetails(val jobId: String) : SlicedWorkRoute
}