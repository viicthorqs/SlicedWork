package com.slicedwork.designsystem.components.skeleton

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
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
    const val TRANSITION_LABEL = "designsystem_skeleton_pulse"
    const val PULSE_DURATION_MS = 900
    val LineCornerRadius = 4.dp
    val ImageCornerRadius = 8.dp
    val CardElevation = 6.dp
}

/**
 * Cor pulsante **opaca**: interpola entre [ColorScheme.surfaceVariant] e [ColorScheme.outline].
 * (Em alguns temas, `outlineVariant` == `surfaceVariant` no dark — aí o pulse sumia.)
 * Evita `surfaceVariant.copy(alpha = …)` baixo, que em temas claros quase desaparece em `background`/`surface`.
 */
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
    return lerp(scheme.surfaceVariant, scheme.outline, t)
}

/**
 * Faixa horizontal (título, texto, etc.). Largura vem do [modifier] (ex.: [Modifier.fillMaxWidth], [Modifier.width]).
 */
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

/**
 * Placeholder circular (avatar, ícone).
 */
@Composable
fun SkeletonCircle(
    modifier: Modifier = Modifier,
    color: Color = rememberSkeletonPulseColor(),
) {
    Box(
        modifier
            .clip(CircleShape)
            .background(color),
    )
}

/**
 * Placeholder retangular com cantos arredondados (imagem, thumbnail, bloco).
 */
@Composable
fun SkeletonImage(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(SkeletonLoaderDefaults.ImageCornerRadius),
    color: Color = rememberSkeletonPulseColor(),
) {
    Box(
        modifier
            .clip(shape)
            .background(color),
    )
}

/**
 * [Card] elevado para agrupar skeletons (lista, formulário, etc.).
 */
@Composable
fun SkeletonCard(
    modifier: Modifier = Modifier,
    elevation: Dp = SkeletonLoaderDefaults.CardElevation,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = elevation),
        content = content,
    )
}
