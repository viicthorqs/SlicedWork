package com.slicedwork.jobdetails.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.slicedwork.jobdetails.presentation.JobDetailsIntent
import com.slicedwork.jobdetails.presentation.JobDetailsUiState
import com.slicedwork.jobdetails.presentation.JobDetailsViewModel
import com.slicedwork.jobdetails.ui.screenstate.JobDetailsError
import com.slicedwork.jobdetails.ui.screenstate.JobDetailsLoading
import com.slicedwork.jobdetails.ui.screenstate.JobDetailsSuccess
import org.koin.androidx.compose.koinViewModel

@Composable
fun JobDetailsRoute(
    viewModel: JobDetailsViewModel = koinViewModel(),
    jobId: String,
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onIntent(JobDetailsIntent.LoadJob(jobId))
    }

    JobDetailsScreen(uiState)
}

@Composable
fun JobDetailsScreen(uiState: JobDetailsUiState) = when (uiState) {
    JobDetailsUiState.Loading -> JobDetailsLoading()
    is JobDetailsUiState.Error -> JobDetailsError(errorMessage = uiState.errorMessage)
    is JobDetailsUiState.Success -> JobDetailsSuccess(job = uiState.job)
}