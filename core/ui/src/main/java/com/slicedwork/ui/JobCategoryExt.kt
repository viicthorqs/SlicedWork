package com.slicedwork.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.domain.model.JobCategory.ANY
import com.slicedwork.domain.model.JobCategory.CLEANING
import com.slicedwork.domain.model.JobCategory.CONSTRUCTION
import com.slicedwork.domain.model.JobCategory.ELECTRIC
import com.slicedwork.domain.model.JobCategory.GARDENING
import com.slicedwork.domain.model.JobCategory.PAINTING
import com.slicedwork.domain.model.JobCategory.PLUMBING

fun JobCategory.toUi(): JobCategoryUi = when (this) {
    PAINTING -> JobCategoryUi(R.drawable.ic_painting, R.string.job_category_painting)
    CLEANING -> JobCategoryUi(R.drawable.ic_cleaning, R.string.job_category_cleaning)
    GARDENING -> JobCategoryUi(R.drawable.ic_gardening, R.string.job_category_gardening)
    CONSTRUCTION -> JobCategoryUi(R.drawable.ic_construction, R.string.job_category_construction)
    ELECTRIC -> JobCategoryUi(R.drawable.ic_electric, R.string.job_category_electric)
    PLUMBING -> JobCategoryUi(R.drawable.ic_plumbing, R.string.job_category_plumbing)
    ANY -> JobCategoryUi(R.drawable.ic_any, R.string.job_category_any)
}

data class JobCategoryUi(
    @field:DrawableRes val iconRes: Int,
    @field:StringRes val titleRes: Int,
)