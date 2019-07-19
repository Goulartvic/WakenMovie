package com.tanheta.wakenmovie.data.remote

import com.tanheta.wakenmovie.base.extensions.awaitResult
import com.tanheta.wakenmovie.data.model.ServiceResponse
import com.tanheta.wakenmovie.data.model.dto.MovieDto
import com.tanheta.wakenmovie.data.model.dto.ResultsDto
import com.tanheta.wakenmovie.data.model.dto.SimpleMovieDto
import kotlinx.coroutines.delay

class MovieService(private val api: MovieApi) : MovieRepository {
    override suspend fun getUpcomingMovies(page: Long): ServiceResponse<ResultsDto> {
        return api.getUpcomingMovies(page).awaitResult()
    }

    override suspend fun getMovie(movieId: Long): ServiceResponse<MovieDto> {
        delay(2200)

        return api.getMovie(movieId).awaitResult()
    }

}