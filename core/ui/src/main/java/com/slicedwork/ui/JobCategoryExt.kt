package com.slicedwork.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.slicedwork.domain.model.JobCategory

fun JobCategory.toUi(): JobCategoryUi = when (this) {
    JobCategory.PAINTING -> JobCategoryUi(R.drawable.ic_painting, R.string.painting)
    JobCategory.CLEANING -> JobCategoryUi(R.drawable.ic_cleaning, R.string.cleaning)
    JobCategory.GARDENING -> JobCategoryUi(R.drawable.ic_gardening, R.string.gardening)
    JobCategory.CONSTRUCTION -> JobCategoryUi(R.drawable.ic_construction, R.string.construction)
    JobCategory.ELECTRIC -> JobCategoryUi(R.drawable.ic_electric, R.string.electric)
    JobCategory.PLUMBING -> JobCategoryUi(R.drawable.ic_plumbing, R.string.plumbing)
    JobCategory.ANY -> JobCategoryUi(R.drawable.ic_any, R.string.any)
}

data class JobCategoryUi(
    @field:DrawableRes val imageRes: Int,
    @field:StringRes val stringRes: Int,
)