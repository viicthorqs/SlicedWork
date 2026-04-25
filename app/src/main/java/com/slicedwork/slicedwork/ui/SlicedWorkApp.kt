package com.slicedwork.slicedwork.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.slicedwork.slicedwork.SlicedWorkRoute

@Composable
fun SlicedWorkApp() {
    val backStack = remember { mutableStateListOf<SlicedWorkRoute>(SlicedWorkRoute.Home) }
    val currentRoute = backStack.lastOrNull()

    Scaffold(
        topBar = {
            SlicedWorkTopBar(
                currentRoute = currentRoute,
                canNavigateBack = backStack.size > 1,
                onBackClick = { backStack.removeLastOrNull() }
            )
        },
        contentWindowInsets = WindowInsets.safeDrawing,
        content = { innerPadding ->
            SlicedWorkContent(backStack = backStack, innerPadding = innerPadding)
        }
    )
}
