package com.slicedwork.jobdetails.ui.screenstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slicedwork.designsystem.components.skeleton.SkeletonCard
import com.slicedwork.designsystem.components.skeleton.SkeletonLine
import com.slicedwork.designsystem.components.skeleton.rememberSkeletonPulseColor
import com.slicedwork.designsystem.theme.SlicedWorkTheme

@Composable
fun JobDetailsLoading(modifier: Modifier = Modifier) {
    val pulse = rememberSkeletonPulseColor()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        JobDetailsHeaderSkeleton(pulse = pulse)

        JobDetailsSectionSkeleton(pulse = pulse)

        JobDetailsSectionSkeleton(pulse = pulse)

        JobDetailsSectionSkeleton(pulse = pulse)
    }
}

@Composable
private fun JobDetailsHeaderSkeleton(pulse: androidx.compose.ui.graphics.Color) {
    SkeletonCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(112.dp),
        color = pulse,
    )
}

@Composable
private fun JobDetailsSectionSkeleton(
    pulse: androidx.compose.ui.graphics.Color,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SkeletonLine(
            modifier = Modifier.width(112.dp),
            height = 22.dp,
            color = pulse,
        )
        SkeletonCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            color = pulse,
        )
    }
}

@Composable
private fun JobDetailsLoadingPreviewSurface(darkTheme: Boolean) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            JobDetailsLoading(modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(name = "Job Details Loading Light")
@Composable
private fun JobDetailsLoadingLightPreview() = JobDetailsLoadingPreviewSurface(darkTheme = false)

@Preview(name = "Job Details Loading Dark")
@Composable
private fun JobDetailsLoadingDarkPreview() = JobDetailsLoadingPreviewSurface(darkTheme = true)