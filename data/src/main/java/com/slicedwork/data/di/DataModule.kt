package com.slicedwork.data.di

import com.slicedwork.data.repository.fake.FakeJobCategoryRepository
import com.slicedwork.data.repository.fake.FakeJobRepository
import com.slicedwork.domain.repository.JobCategoryRepository
import com.slicedwork.domain.repository.JobRepository
import org.koin.dsl.module

val DataModule = module {
    single<JobRepository> { FakeJobRepository() }
    single<JobCategoryRepository> { FakeJobCategoryRepository() }
}
