package com.slicedwork.home.ui.screenstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slicedwork.designsystem.components.skeleton.SkeletonCard
import com.slicedwork.designsystem.components.skeleton.SkeletonCircle
import com.slicedwork.designsystem.components.skeleton.SkeletonLine
import com.slicedwork.designsystem.components.skeleton.rememberSkeletonPulseColor
import com.slicedwork.designsystem.theme.SlicedWorkTheme

private const val SkeletonPlaceholders = 5

@Composable
fun HomeLoading(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(SkeletonPlaceholders) {
            HomeJobCardSkeleton(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun HomeJobCardSkeleton(modifier: Modifier = Modifier) {
    val pulse = rememberSkeletonPulseColor()

    SkeletonCard(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SkeletonCircle(
                modifier = Modifier.size(56.dp),
                color = pulse,
            )
            Spacer(Modifier.width(8.dp))
            Column(Modifier.weight(1f)) {
                SkeletonLine(
                    modifier = Modifier.fillMaxWidth(0.92f),
                    height = 20.dp,
                    color = pulse,
                )
                Spacer(Modifier.height(16.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    SkeletonLine(
                        modifier = Modifier.weight(1f),
                        height = 16.dp,
                        color = pulse,
                    )
                    Spacer(Modifier.width(16.dp))
                    SkeletonLine(
                        modifier = Modifier.width(72.dp),
                        height = 22.dp,
                        color = pulse,
                    )
                }
            }
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
            HomeLoading()
        }
    }
}

@Preview(name = "Loading Light")
@Composable
private fun PreviewHomeLoadingLight() = HomeLoadingPreviewSurface(darkTheme = false)

@Preview(name = "Loading Dark", showBackground = true)
@Composable
private fun PreviewHomeLoadingDark() = HomeLoadingPreviewSurface(darkTheme = true)
