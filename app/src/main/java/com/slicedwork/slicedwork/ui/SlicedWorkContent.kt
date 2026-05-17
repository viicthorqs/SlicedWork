package com.slicedwork.slicedwork.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy.Companion.detailPane
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy.Companion.listPane
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.slicedwork.home.ui.HomeRoute
import com.slicedwork.jobdetails.ui.JobDetailsPlaceholder
import com.slicedwork.jobdetails.ui.JobDetailsRoute
import com.slicedwork.joblist.ui.JobListRoute
import com.slicedwork.slicedwork.SlicedWorkRoute
import com.slicedwork.slicedwork.SlicedWorkRoute.Home
import com.slicedwork.slicedwork.SlicedWorkRoute.JobDetails
import com.slicedwork.slicedwork.SlicedWorkRoute.JobList

private const val TWO_GRID_COLUMNS = 2
private const val THREE_GRID_COLUMNS = 3

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SlicedWorkContent(
    sceneStrategies: List<SceneStrategy<SlicedWorkRoute>>,
    backStack: SnapshotStateList<SlicedWorkRoute>,
    isCompact: Boolean,
    innerPadding: PaddingValues,
    onBack: () -> Unit,
) {
    NavDisplay(
        backStack = backStack,
        sceneStrategies = sceneStrategies,
        onBack = onBack,
        modifier = Modifier.padding(innerPadding),
        entryProvider = entryProvider {
            entry<Home> {
                HomeRoute(
                    gridColumns = if (isCompact) TWO_GRID_COLUMNS else THREE_GRID_COLUMNS,
                    onNavigateToJobList = { jobCategory ->
                        backStack.add(JobList(jobCategory = jobCategory))
                    }
                )
            }
            entry<JobList>(metadata = listPane(detailPlaceholder = { JobDetailsPlaceholder() })) { route ->
                JobListRoute(
                    jobCategory = route.jobCategory,
                    onNavigateToJobDetails = { jobId ->
                        backStack.navigateToJobDetails(jobId = jobId, isCompact = isCompact)
                    }
                )
            }
            entry<JobDetails>(metadata = detailPane()) { route ->
                JobDetailsRoute(jobId = route.jobId)
            }
        }
    )
}

private fun SnapshotStateList<SlicedWorkRoute>.navigateToJobDetails(
    jobId: String,
    isCompact: Boolean,
) {
    if (!isCompact && lastOrNull() is JobDetails) removeLastOrNull()

    add(JobDetails(jobId = jobId))
}