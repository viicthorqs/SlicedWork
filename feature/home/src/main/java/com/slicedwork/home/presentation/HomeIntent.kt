package com.slicedwork.home.presentation

sealed class HomeIntent {
    data object LoadJobs : HomeIntent()
}
