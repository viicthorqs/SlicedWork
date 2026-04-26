package com.slicedwork.jobdetails.di

import com.slicedwork.jobdetails.presentation.JobDetailsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val JobDetailsModule = module {
    viewModelOf(::JobDetailsViewModel)
}
