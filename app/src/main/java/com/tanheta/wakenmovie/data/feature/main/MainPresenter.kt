package com.tanheta.wakenmovie.data.feature.main

import com.tanheta.wakenmovie.base.extensions.launch
import com.tanheta.wakenmovie.data.model.whenever
import com.tanheta.wakenmovie.data.remote.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher

class MainPresenter(
    override var view: MainContract.View,
    private val movieRepository: MovieRepository,
    private val dispatcherContext: CoroutineDispatcher
) : MainContract.Presenter {
    override fun loadMovies(page: Long) {
        view.showLoadingMovies()

        dispatcherContext.launch {
            movieRepository.getUpcomingMovies(page).whenever(
                isBody = {result ->
                    view.hideLoadingMovies()
                    view.onSuccessfulLoadMovies(result.results)
                },
                isError = {msg ->
                    view.hideLoadingMovies()
                    view.onFailureLoadMovies(msg)
                }
            )
        }
    }

}