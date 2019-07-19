package com.tanheta.wakenmovie.data.feature.main

import com.tanheta.wakenmovie.base.BasePresenter
import com.tanheta.wakenmovie.base.BaseView
import com.tanheta.wakenmovie.data.model.dto.SimpleMovieDto

interface MainContract {
    interface View : BaseView<Presenter> {
        fun showLoadingMovies()
        fun hideLoadingMovies()
        fun onSuccessfulLoadMovies(movies: List<SimpleMovieDto>)
        fun onFailureLoadMovies(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun loadMovies(page: Long)
    }
}
