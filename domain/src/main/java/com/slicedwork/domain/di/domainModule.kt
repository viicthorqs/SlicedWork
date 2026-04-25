package com.slicedwork.domain.di

import com.slicedwork.domain.usecase.GetJobUseCase
import com.slicedwork.domain.usecase.GetJobsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetJobsUseCase(get()) }
    factory { GetJobUseCase(get()) }
}
