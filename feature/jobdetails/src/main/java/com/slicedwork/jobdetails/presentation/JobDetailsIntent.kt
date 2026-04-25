package com.slicedwork.jobdetails.presentation

sealed class JobDetailsIntent {
    data class LoadJob(val jobId: String) : JobDetailsIntent()
}