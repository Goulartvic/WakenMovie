package com.tanheta.wakenmovie.data.remote

import com.tanheta.wakenmovie.data.model.ServiceResponse
import com.tanheta.wakenmovie.data.model.dto.MovieDto
import com.tanheta.wakenmovie.data.model.dto.ResultsDto
import com.tanheta.wakenmovie.data.model.dto.SimpleMovieDto

interface MovieRepository {

    suspend fun getUpcomingMovies(page: Long): ServiceResponse<ResultsDto>
    suspend fun getMovie(movieId: Long): ServiceResponse<MovieDto>
}