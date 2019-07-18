package com.tanheta.wakenmovie.base.modules

import com.tanheta.wakenmovie.data.remote.MovieApi
import com.tanheta.wakenmovie.data.remote.MovieRepository
import com.tanheta.wakenmovie.data.remote.MovieService
import org.koin.dsl.module.module
import retrofit2.Retrofit

val repositoryModule = module {
    factory { get<Retrofit>(BASE_SERVER).create(MovieApi::class.java) }

    factory { MovieService(api = get()) } bind MovieRepository::class
}