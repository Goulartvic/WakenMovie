package com.tanheta.wakenmovie.base.app

import android.app.Application
import com.tanheta.wakenmovie.base.modules.appModule
import com.tanheta.wakenmovie.base.modules.dispatcherModule
import com.tanheta.wakenmovie.base.modules.featureModule
import com.tanheta.wakenmovie.base.modules.retrofitClientModule
import org.koin.android.ext.android.startKoin

@Suppress("unused")
class App : Application() {

    private val modules = listOf(
        appModule,
        featureModule,
        dispatcherModule,
        retrofitClientModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin(this, modules)
    }
}