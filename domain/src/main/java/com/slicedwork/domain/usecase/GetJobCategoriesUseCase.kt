package com.slicedwork.domain.usecase

import com.slicedwork.domain.model.JobCategory
import com.slicedwork.domain.repository.JobCategoryRepository

class GetJobCategoriesUseCase(val repository: JobCategoryRepository) {
    suspend operator fun invoke(): List<JobCategory> {
        return repository.getJobCategories()
    }
}