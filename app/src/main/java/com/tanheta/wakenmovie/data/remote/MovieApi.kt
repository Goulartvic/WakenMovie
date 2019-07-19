package com.tanheta.wakenmovie.data.remote

import com.tanheta.wakenmovie.BuildConfig
import com.tanheta.wakenmovie.data.model.dto.MovieDto
import com.tanheta.wakenmovie.data.model.dto.ResultsDto
import com.tanheta.wakenmovie.data.model.dto.SimpleMovieDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("page")page: Long,
                          @Query("api_key")apiKey: String = BuildConfig.TMDB_API_KEY): Call<ResultsDto>

    @GET("movie/{movie_id}")
    fun getMovie(@Path("movie_id") id: Long,
                 @Query("api_key")apiKey: String = BuildConfig.TMDB_API_KEY): Call<MovieDto>
}