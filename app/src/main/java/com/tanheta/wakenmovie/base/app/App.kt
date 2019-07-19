package com.tanheta.wakenmovie.base.app

import android.app.Application
import com.tanheta.wakenmovie.base.modules.*
import org.koin.android.ext.android.startKoin

@Suppress("unused")
class App : Application() {

    private val modules = listOf(
        appModule,
        featureModule,
        dispatcherModule,
        retrofitClientModule,
        repositoryModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin(this, modules)
    }
}