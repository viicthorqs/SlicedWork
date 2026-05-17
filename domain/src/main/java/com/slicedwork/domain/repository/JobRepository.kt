package com.slicedwork.domain.repository

import com.slicedwork.domain.model.Job
import com.slicedwork.domain.model.JobCategory

interface JobRepository {
    suspend fun getJobs(jobCategory: JobCategory): List<Job>

    fun getJob(jobId: String): Job?
}
