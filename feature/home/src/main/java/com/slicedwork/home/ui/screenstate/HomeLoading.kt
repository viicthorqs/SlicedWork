package com.slicedwork.home.ui.screenstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
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
fun HomeLoading(
    gridColumns: Int,
    modifier: Modifier = Modifier,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(gridColumns),
        verticalItemSpacing = 16.dp,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize(),
    ) {
        items(SkeletonPlaceholders) {
            SkeletonCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(116.dp),
            )
        }
    }
}

@Composable
private fun HomeLoadingPreviewSurface(
    darkTheme: Boolean,
    gridColumns: Int,
) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            HomeLoading(
                gridColumns = gridColumns,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

@Preview(name = "Home Loading Light")
@Composable
private fun HomeLoadingLightPreview() = HomeLoadingPreviewSurface(
    darkTheme = false,
    gridColumns = 2,
)

@Preview(name = "Home Loading Dark")
@Composable
private fun HomeLoadingDarkPreview() = HomeLoadingPreviewSurface(
    darkTheme = true,
    gridColumns = 2,
)

@Preview(name = "Wide Home Loading Light", widthDp = 1000, heightDp = 600)
@Composable
private fun WideHomeLoadingLightPreview() = HomeLoadingPreviewSurface(
    darkTheme = false,
    gridColumns = 3,
)

@Preview(name = "Wide Home Loading Dark", widthDp = 1000, heightDp = 600)
@Composable
private fun WideHomeLoadingDarkPreview() = HomeLoadingPreviewSurface(
    darkTheme = true,
    gridColumns = 3,
)