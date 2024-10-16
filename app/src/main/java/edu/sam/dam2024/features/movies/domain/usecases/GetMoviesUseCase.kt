package edu.sam.dam2024.features.movies.domain.usecases

import edu.sam.dam2024.features.movies.domain.model.Movie
import edu.sam.dam2024.features.movies.domain.MovieRepository

/*
Naming: Verbo(Accion) + UseCase
 */
class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    //same as fun execute()
    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }


}