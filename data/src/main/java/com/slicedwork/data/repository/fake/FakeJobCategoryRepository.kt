package com.slicedwork.data.repository.fake

import com.slicedwork.domain.model.JobCategory
import com.slicedwork.domain.repository.JobCategoryRepository

class FakeJobCategoryRepository: JobCategoryRepository {
    override fun getJobCategories(): List<JobCategory> {
        return listOf(JobCategory.ANY) +
                FakeJobCatalog.jobs
                    .map { job -> job.category }
                    .distinct()
    }
}