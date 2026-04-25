package com.slicedwork.slicedwork

import android.app.Application
import com.slicedwork.data.di.dataModule
import com.slicedwork.domain.di.domainModule
import com.slicedwork.home.di.homeModule
import com.slicedwork.jobdetails.di.jobDetailsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SlicedWorkApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SlicedWorkApplication)
            modules(
                domainModule,
                dataModule,
                homeModule,
                jobDetailsModule,
            )
        }
    }
}