package com.tanheta.wakenmovie.data.feature.movie

import com.tanheta.wakenmovie.base.BasePresenter
import com.tanheta.wakenmovie.base.BaseView
import com.tanheta.wakenmovie.data.model.dto.MovieDto

interface MovieContract {
    interface View : BaseView<Presenter> {
        fun showLoadingMovies()
        fun hideLoadingMovies()
        fun onSuccessfulLoadMovie(movie: MovieDto)
        fun onFailuereLoadMovie(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun loadMovie(gameId: Long)
    }
}