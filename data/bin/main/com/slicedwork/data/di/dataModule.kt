package com.slicedwork.data.di

import com.slicedwork.data.repository.fake.FakeJobRepository
import com.slicedwork.domain.repository.JobRepository
import org.koin.dsl.module

val dataModule = module {
    single<JobRepository> { FakeJobRepository() }
}