package com.slicedwork.home.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.slicedwork.home.presentation.HomeEffect
import com.slicedwork.home.presentation.HomeIntent
import com.slicedwork.home.presentation.HomeUiState
import com.slicedwork.home.presentation.HomeViewModel
import com.slicedwork.home.ui.screenstate.HomeError
import com.slicedwork.home.ui.screenstate.HomeLoading
import com.slicedwork.home.ui.screenstate.HomeSuccess
import kotlinx.coroutines.Job
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    onNavigateToJobDetails: (String) -> Unit,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onIntent(HomeIntent.LoadJobs)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToJobDetails -> {
                    onNavigateToJobDetails(effect.jobId)
                }
            }
        }
    }

    HomeScreen(
        uiState = uiState,
        onIntent = viewModel::onIntent,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onIntent: (HomeIntent) -> Job,
    modifier: Modifier,
) {
    when (uiState) {
        HomeUiState.Loading -> HomeLoading(modifier)
        is HomeUiState.Error -> HomeError(message = uiState.errorMessage)
        is HomeUiState.Success -> HomeSuccess(
            jobs = uiState.jobs,
            onJobClicked = { jobId -> onIntent(HomeIntent.JobClicked(jobId = jobId)) },
            modifier = modifier
        )
    }
}