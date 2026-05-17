package com.slicedwork.home.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.home.presentation.HomeEffect
import com.slicedwork.home.presentation.HomeIntent
import com.slicedwork.home.presentation.HomeUiState
import com.slicedwork.home.presentation.HomeViewModel
import com.slicedwork.home.ui.screenstate.HomeError
import com.slicedwork.home.ui.screenstate.HomeLoading
import com.slicedwork.home.ui.screenstate.HomeSuccess
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute(
    gridColumns: Int,
    onNavigateToJobList: (JobCategory) -> Unit,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onIntent(HomeIntent.LoadJobCategories)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToJobList -> {
                    onNavigateToJobList(effect.jobCategory)
                }
            }
        }
    }

    HomeScreen(
        uiState = uiState,
        gridColumns = gridColumns,
        onIntent = viewModel::onIntent,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onIntent: (HomeIntent) -> Unit,
    gridColumns: Int,
    modifier: Modifier
) {
    when (uiState) {
        HomeUiState.Loading -> HomeLoading(gridColumns = gridColumns, modifier = modifier)
        is HomeUiState.Error -> HomeError(message = uiState.errorMessage)
        is HomeUiState.Success -> HomeSuccess(
            jobCategories = uiState.jobCategories,
            gridColumns = gridColumns,
            onJobCategoryClicked = { jobCategory ->
                onIntent(
                    HomeIntent.JobCategoryClicked(jobCategory = jobCategory)
                )
            },
            modifier = modifier
        )
    }
}