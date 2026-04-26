package com.slicedwork.slicedwork.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy.Companion.detailPane
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy.Companion.listPane
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.slicedwork.home.ui.HomeRoute
import com.slicedwork.jobdetails.ui.JobDetailsPlaceholder
import com.slicedwork.jobdetails.ui.JobDetailsRoute
import com.slicedwork.slicedwork.SlicedWorkRoute
import com.slicedwork.slicedwork.SlicedWorkRoute.Home
import com.slicedwork.slicedwork.SlicedWorkRoute.JobDetails

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SlicedWorkContent(
    sceneStrategies: List<SceneStrategy<SlicedWorkRoute>>,
    backStack: SnapshotStateList<SlicedWorkRoute>,
    innerPadding: PaddingValues
) {
    NavDisplay(
        backStack = backStack,
        sceneStrategies = sceneStrategies,
        onBack = { backStack.removeLastOrNull() },
        modifier = Modifier.padding(innerPadding),
        entryProvider = entryProvider {
            entry<Home>(metadata = listPane(detailPlaceholder = { JobDetailsPlaceholder() })) {
                HomeRoute(
                    onNavigateToJobDetails = { jobId ->
                        backStack.add(JobDetails(jobId = jobId))
                    }
                )
            }
            entry<JobDetails>(metadata = detailPane()) { route ->
                JobDetailsRoute(jobId = route.jobId)
            }
        }
    )
}
