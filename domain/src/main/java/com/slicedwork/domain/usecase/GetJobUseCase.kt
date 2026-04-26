package com.slicedwork.domain.usecase

import com.slicedwork.domain.model.Job
import com.slicedwork.domain.repository.JobRepository

class GetJobUseCase(private val repository: JobRepository) {
    suspend operator fun invoke(jobId: String): Job? {
        return repository.getJob(jobId = jobId)
    }
}
