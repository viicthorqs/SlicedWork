package com.slicedwork.jobdetails.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
    jobId: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: JobDetailsViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(jobId) {
        viewModel.onIntent(JobDetailsIntent.LoadJob(jobId))
    }

    JobDetailsScreen(uiState = uiState, modifier = modifier)
}

@Composable
fun JobDetailsScreen(uiState: JobDetailsUiState, modifier: Modifier = Modifier) = when (uiState) {
    JobDetailsUiState.Loading -> JobDetailsLoading(modifier = modifier)
    is JobDetailsUiState.Error -> JobDetailsError(errorMessage = uiState.errorMessage)
    is JobDetailsUiState.Success -> JobDetailsSuccess(job = uiState.job, modifier = modifier)
}