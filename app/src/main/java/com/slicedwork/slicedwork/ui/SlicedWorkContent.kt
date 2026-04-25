package com.slicedwork.slicedwork.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.slicedwork.home.ui.HomeRoute
import com.slicedwork.jobdetails.ui.JobDetailsRoute
import com.slicedwork.slicedwork.SlicedWorkRoute

@Composable
fun SlicedWorkContent(
    backStack: SnapshotStateList<SlicedWorkRoute>,
    innerPadding: PaddingValues
) {
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        modifier = Modifier.padding(innerPadding),
        entryProvider = { route ->
            when (route) {
                SlicedWorkRoute.Home -> NavEntry(route) {
                    HomeRoute(
                        onNavigateToJobDetails = { jobId ->
                            backStack.add(SlicedWorkRoute.JobDetails(jobId))
                        }
                    )
                }

                is SlicedWorkRoute.JobDetails -> NavEntry(route) {
                    JobDetailsRoute(jobId = route.jobId, onBackClick = {})
                }
            }
        }
    )
}
