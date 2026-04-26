package com.slicedwork.domain.repository

import com.slicedwork.domain.model.Job

interface JobRepository {
    suspend fun getJobs(): List<Job>

    fun getJob(jobId: String): Job?
}
