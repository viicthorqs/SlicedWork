package com.slicedwork.data.repository.fake

import com.slicedwork.domain.model.Job
import com.slicedwork.domain.repository.JobRepository

class FakeJobRepository : JobRepository {
    override suspend fun getJobs(): List<Job> = FakeJobCatalog.jobs

    override fun getJob(jobId: String): Job? =
        FakeJobCatalog.jobs.find { job ->
            job.id == jobId
        }
}
