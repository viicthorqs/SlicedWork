package com.slicedwork.slicedwork.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.window.core.layout.WindowSizeClass
import com.slicedwork.slicedwork.SlicedWorkRoute

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SlicedWorkApp() {
    val backStack = remember { mutableStateListOf<SlicedWorkRoute>(SlicedWorkRoute.Home) }
    val listDetailStrategy = rememberListDetailSceneStrategy<SlicedWorkRoute>()

    val isCompact = !currentWindowAdaptiveInfo()
        .windowSizeClass
        .isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)
    val currentRoute = backStack.lastOrNull()
    val canNavigateBack = backStack.size > 1
    val onBack: () -> Unit = {
        backStack.navigateBack(isCompact = isCompact)
    }

    Scaffold(
        topBar = {
            SlicedWorkTopBar(
                currentRoute = currentRoute,
                canNavigateBack = canNavigateBack,
                onBackClick = onBack
            )
        },
        contentWindowInsets = WindowInsets.safeDrawing,
        content = { innerPadding ->
            SlicedWorkContent(
                sceneStrategies = listOf(listDetailStrategy),
                backStack = backStack,
                isCompact = isCompact,
                innerPadding = innerPadding,
                onBack = onBack
            )
        }
    )
}

private fun SnapshotStateList<SlicedWorkRoute>.navigateBack(isCompact: Boolean) {
    if (size <= 1) return

    if (!isCompact && lastOrNull() is SlicedWorkRoute.JobDetails) {
        popToHome()
    } else {
        removeLastOrNull()
    }
}

private fun SnapshotStateList<SlicedWorkRoute>.popToHome() {
    while (lastOrNull() !is SlicedWorkRoute.Home && size > 1) {
        removeLastOrNull()
    }
}