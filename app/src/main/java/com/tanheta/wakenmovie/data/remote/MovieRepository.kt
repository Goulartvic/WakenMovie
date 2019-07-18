package com.tanheta.wakenmovie.data.remote

import com.tanheta.wakenmovie.data.model.ServiceResponse
import com.tanheta.wakenmovie.data.model.dto.MovieDto
import com.tanheta.wakenmovie.data.model.dto.SimpleMovieDto

interface MovieRepository {

    suspend fun getUpcomingMovies(page: Long): ServiceResponse<List<SimpleMovieDto>>
    suspend fun getMovie(movieId: Long): ServiceResponse<MovieDto>
}