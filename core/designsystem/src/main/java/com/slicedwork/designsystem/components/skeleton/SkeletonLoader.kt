package com.slicedwork.designsystem.components.skeleton

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object SkeletonLoaderDefaults {
    const val TRANSITION_LABEL = "design_system_skeleton_pulse"
    const val PULSE_DURATION_MS = 900
    val LineCornerRadius = 4.dp
    val CardElevation = 6.dp
}

@Composable
fun rememberSkeletonPulseColor(): Color {
    val transition = rememberInfiniteTransition(label = SkeletonLoaderDefaults.TRANSITION_LABEL)
    val t by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = SkeletonLoaderDefaults.PULSE_DURATION_MS,
                easing = FastOutSlowInEasing,
            ),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "skeletonPulse",
    )
    val scheme = MaterialTheme.colorScheme
    return lerp(scheme.surfaceContainer, scheme.surfaceContainerHighest, t)
}

@Composable
fun SkeletonLine(
    modifier: Modifier = Modifier,
    height: Dp = 16.dp,
    shape: Shape = RoundedCornerShape(SkeletonLoaderDefaults.LineCornerRadius),
    color: Color = rememberSkeletonPulseColor(),
) {
    Box(
        modifier
            .height(height)
            .clip(shape)
            .background(color),
    )
}

@Composable
fun SkeletonCard(
    modifier: Modifier = Modifier,
    elevation: Dp = SkeletonLoaderDefaults.CardElevation,
    color: Color = rememberSkeletonPulseColor(),
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = elevation),
    ) {}
}
