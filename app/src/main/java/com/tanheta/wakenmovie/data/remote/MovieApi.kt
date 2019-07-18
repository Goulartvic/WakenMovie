package com.tanheta.wakenmovie.data.remote

import com.tanheta.wakenmovie.BuildConfig
import com.tanheta.wakenmovie.data.model.dto.MovieDto
import com.tanheta.wakenmovie.data.model.dto.SimpleMovieDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("/movie/upcoming?" + BuildConfig.TMDB_API_KEY)
    fun getUpcomingMovies(@Query("page")page: Long): Call<List<SimpleMovieDto>>

    @GET("/movie/{movie_id}" + BuildConfig.TMDB_API_KEY)
    fun getMovie(@Path("movie_id") id: Long): Call<MovieDto>
}