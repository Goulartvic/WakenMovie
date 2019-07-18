package com.tanheta.wakenmovie.data.model.dto

data class SimpleMovieDto(
    val title: String,
    val posterPath: String,
    val id: Long,
    val voteAverage: Double
)