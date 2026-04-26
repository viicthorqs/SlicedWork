package com.slicedwork.slicedwork

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface SlicedWorkRoute: NavKey {
    @Serializable
    data object Home : SlicedWorkRoute
    @Serializable
    data class JobDetails(val jobId: String) : SlicedWorkRoute
}