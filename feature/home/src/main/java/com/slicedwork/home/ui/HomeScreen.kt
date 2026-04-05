package com.slicedwork.home.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slicedwork.home.presentation.HomeIntent
import com.slicedwork.home.presentation.HomeUiState
import com.slicedwork.home.presentation.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.intent(HomeIntent.LoadJobs)
    }

    Scaffold { innerPadding ->
        HomeContent(state = state, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun HomeContent(state: HomeUiState, modifier: Modifier) = when (state) {
    HomeUiState.Loading -> HomeLoading(modifier = modifier.fillMaxSize())
    is HomeUiState.Success -> HomeJobList(
        jobs = state.jobs,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    )
    is HomeUiState.Error -> HomeError(
        message = state.errorMessage,
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
    )
}
