package com.slicedwork.slicedwork

import android.app.Application
import com.slicedwork.data.di.DataModule
import com.slicedwork.domain.di.DomainModule
import com.slicedwork.home.di.HomeModule
import com.slicedwork.jobdetails.di.JobDetailsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SlicedWorkApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SlicedWorkApplication)
            modules(
                DomainModule,
                DataModule,
                HomeModule,
                JobDetailsModule,
            )
        }
    }
}