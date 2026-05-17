package com.slicedwork.home.presentation

import com.slicedwork.domain.model.JobCategory

sealed interface HomeEffect {
    data class NavigateToJobList(val jobCategory: JobCategory = JobCategory.ANY) : HomeEffect
}