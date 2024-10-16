package edu.sam.dam2024.features.movies.domain.usecases

import edu.sam.dam2024.features.movies.domain.model.Movie
import edu.sam.dam2024.features.movies.domain.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(movieId: String): Movie? {
        return movieRepository.getMovie(movieId)
    }

}