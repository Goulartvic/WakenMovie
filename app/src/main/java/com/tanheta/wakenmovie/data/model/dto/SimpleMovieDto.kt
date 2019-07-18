package com.tanheta.wakenmovie.data.model.dto

import com.google.gson.annotations.SerializedName

data class SimpleMovieDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("vote_average")
    val voteAverage: Double
)