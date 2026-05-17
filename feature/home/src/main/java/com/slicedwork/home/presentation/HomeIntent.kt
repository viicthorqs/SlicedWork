package com.slicedwork.home.presentation

import com.slicedwork.domain.model.JobCategory

sealed class HomeIntent {
    data object LoadJobCategories : HomeIntent()
    data class JobCategoryClicked(val jobCategory: JobCategory = JobCategory.ANY) : HomeIntent()
}
