package com.slicedwork.joblist.presentation

import com.slicedwork.domain.model.JobCategory

sealed class JobListIntent {
    data class LoadJobs(val jobCategory: JobCategory = JobCategory.ANY) : JobListIntent()
    data class JobClicked(val jobId: String) : JobListIntent()
}