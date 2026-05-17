package com.slicedwork.domain.repository

import com.slicedwork.domain.model.JobCategory

interface JobCategoryRepository {
    fun getJobCategories() : List<JobCategory>
}