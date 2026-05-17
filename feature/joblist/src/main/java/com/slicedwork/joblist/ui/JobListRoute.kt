package com.slicedwork.joblist.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.joblist.presentation.JobListEffect
import com.slicedwork.joblist.presentation.JobListIntent
import com.slicedwork.joblist.presentation.JobListUiState
import com.slicedwork.joblist.presentation.JobListViewModel
import com.slicedwork.joblist.ui.screenstate.JobListError
import com.slicedwork.joblist.ui.screenstate.JobListLoading
import com.slicedwork.joblist.ui.screenstate.JobListSuccess
import kotlinx.coroutines.Job
import org.koin.androidx.compose.koinViewModel

@Composable
fun JobListRoute(
    jobCategory: JobCategory,
    onNavigateToJobDetails: (String) -> Unit,
    viewModel: JobListViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onIntent(JobListIntent.LoadJobs(jobCategory))
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is JobListEffect.NavigateToJobDetails -> onNavigateToJobDetails(effect.jobId)
            }
        }
    }

    JobListScreen(
        uiState = uiState,
        onIntent = viewModel::onIntent,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun JobListScreen(
    uiState: JobListUiState,
    onIntent: (JobListIntent) -> Job,
    modifier: Modifier,
) {
    when (uiState) {
        JobListUiState.Loading -> JobListLoading(modifier)
        is JobListUiState.Error -> JobListError(message = uiState.errorMessage)
        is JobListUiState.Success -> JobListSuccess(
            jobs = uiState.jobs,
            onJobClicked = { jobId -> onIntent(JobListIntent.JobClicked(jobId = jobId)) },
            modifier = modifier
        )
    }
}