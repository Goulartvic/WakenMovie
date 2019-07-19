package com.tanheta.wakenmovie.data.feature.movie

import com.tanheta.wakenmovie.base.extensions.launch
import com.tanheta.wakenmovie.data.model.whenever
import com.tanheta.wakenmovie.data.remote.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher

class MoviePresenter(
    override var view: MovieContract.View,
    private val movieRepository: MovieRepository,
    private val dispatcherContext: CoroutineDispatcher
) : MovieContract.Presenter {
    override fun loadMovie(gameId: Long) {
        view.showLoadingMovies()

        dispatcherContext.launch {
            movieRepository.getMovie(gameId).whenever(
                isBody = {
                    view.hideLoadingMovies()
                    view.onSuccessfulLoadMovie(it)
                },
                isError = {
                    view.hideLoadingMovies()
                    view.onFailuereLoadMovie(it)
                }
            )
        }
    }

}