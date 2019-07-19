package com.tanheta.wakenmovie.data.model.dto

data class MovieDto(
    val title: String,
    val posterPath: String,
    val id: Long,
    val voteAverage: Double,
    val originalLanguage: String,
    val overview: String,
    val releaseDate: String
)