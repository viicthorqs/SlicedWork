package com.slicedwork.slicedwork

import androidx.navigation3.runtime.NavKey
import com.slicedwork.domain.model.JobCategory
import kotlinx.serialization.Serializable

@Serializable
sealed interface SlicedWorkRoute: NavKey {
    @Serializable
    data object Home : SlicedWorkRoute
    @Serializable
    data class JobList(val jobCategory: JobCategory = JobCategory.ANY) : SlicedWorkRoute
    @Serializable
    data class JobDetails(val jobId: String) : SlicedWorkRoute
}