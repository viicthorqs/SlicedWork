package com.slicedwork.home.ui.screenstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slicedwork.designsystem.components.skeleton.SkeletonCard
import com.slicedwork.designsystem.theme.SlicedWorkTheme

private const val SkeletonPlaceholders = 10

@Composable
fun HomeLoading(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(SkeletonPlaceholders) {
            SkeletonCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(88.dp),
            )
        }
    }
}

@Composable
private fun HomeLoadingPreviewSurface(darkTheme: Boolean) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            HomeLoading(modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(name = "Loading Light")
@Composable
private fun PreviewHomeLoadingLight() = HomeLoadingPreviewSurface(darkTheme = false)

@Preview(name = "Loading Dark", showBackground = true)
@Composable
private fun PreviewHomeLoadingDark() = HomeLoadingPreviewSurface(darkTheme = true)
