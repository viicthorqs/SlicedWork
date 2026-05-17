package com.slicedwork.joblist.di

import com.slicedwork.joblist.presentation.JobListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val JobListModule = module {
    viewModelOf(::JobListViewModel)
}