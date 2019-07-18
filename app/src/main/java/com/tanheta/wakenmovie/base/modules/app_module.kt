package com.tanheta.wakenmovie.base.modules

import com.google.gson.GsonBuilder
import com.tanheta.wakenmovie.data.feature.main.MainContract
import com.tanheta.wakenmovie.data.feature.main.MainPresenter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import org.koin.dsl.module.module
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    factory { (view: MainContract.View) ->
        MainPresenter(
            view = view,
            movieRepository = get(),
            dispatcherContext = get()
        )
    } bind MainContract.Presenter::class
}

val featureModule = module {
    single {
        GsonConverterFactory.create(GsonBuilder().setLenient().create())
    } bind Converter.Factory::class
}

val dispatcherModule = module {
    factory { Main as CoroutineDispatcher }
}