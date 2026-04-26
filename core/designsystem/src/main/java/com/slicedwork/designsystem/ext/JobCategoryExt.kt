package com.slicedwork.designsystem.ext

import androidx.compose.runtime.Composable
import com.slicedwork.designsystem.R
import com.slicedwork.domain.model.JobCategory

@Composable
fun JobCategory.toPainterResource() = when (this) {
    JobCategory.PAINTING -> R.drawable.ic_painting
    JobCategory.CLEANING -> R.drawable.ic_cleaning
    JobCategory.GARDENING -> R.drawable.ic_gardening
    JobCategory.CONSTRUCTION -> R.drawable.ic_construction
    JobCategory.ELECTRIC -> R.drawable.ic_electric
    JobCategory.PLUMBING -> R.drawable.ic_plumbing
}

@Composable
fun JobCategory.toStringResource() = when (this) {
    JobCategory.PAINTING -> R.string.painting
    JobCategory.CLEANING -> R.string.cleaning
    JobCategory.GARDENING -> R.string.gardening
    JobCategory.CONSTRUCTION -> R.string.construction
    JobCategory.ELECTRIC -> R.string.electric
    JobCategory.PLUMBING -> R.string.plumbing
}
