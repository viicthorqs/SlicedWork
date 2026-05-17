package com.slicedwork.data.repository.fake

import com.slicedwork.domain.model.Job
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.domain.model.JobCategory.ANY
import com.slicedwork.domain.repository.JobRepository

class FakeJobRepository : JobRepository {
    override suspend fun getJobs(jobCategory: JobCategory): List<Job> {
        return when (jobCategory) {
            ANY -> FakeJobCatalog.jobs
            else -> FakeJobCatalog.jobs.filter { job -> job.category == jobCategory }
        }
    }

    override fun getJob(jobId: String): Job? =
        FakeJobCatalog.jobs.find { job ->
            job.id == jobId
        }
}
