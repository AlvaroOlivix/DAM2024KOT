package edu.sam.dam2024.features.movies.domain

import edu.sam.dam2024.features.movies.domain.model.Movie

interface MovieRepository {
    fun getMovies(): List<Movie>
    fun getMovie(movieId: String): Movie?

}