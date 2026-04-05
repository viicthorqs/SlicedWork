package com.slicedwork.designsystem.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.slicedwork.designsystem.R
import com.slicedwork.domain.model.JobCategory

@Composable
fun JobCategory.painter(): Painter = painterResource(
    when (this) {
        JobCategory.PAINTING -> R.drawable.ic_painting
        JobCategory.CLEANING -> R.drawable.ic_cleaning
        JobCategory.GARDENING -> R.drawable.ic_gardening
        JobCategory.CONSTRUCTION -> R.drawable.ic_construction
        JobCategory.ELECTRIC -> R.drawable.ic_electric
        JobCategory.PLUMBING -> R.drawable.ic_plumbing
    },
)
