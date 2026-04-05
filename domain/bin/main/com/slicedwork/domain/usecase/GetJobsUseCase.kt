package com.slicedwork.domain.usecase

import com.slicedwork.domain.model.Job
import com.slicedwork.domain.repository.JobRepository

class GetJobsUseCase(private val repository: JobRepository) {
    suspend operator fun invoke(): List<Job> {
        return repository.getJobs()
    }
}
