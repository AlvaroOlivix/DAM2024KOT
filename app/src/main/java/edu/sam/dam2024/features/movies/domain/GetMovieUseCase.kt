package edu.sam.dam2024.features.movies.domain

/*
Naming: Verbo(Accion) + UseCase
 */
class GetMovieUseCase (private val movieRepository: MovieRepository){

    //same as fun execute()
    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }


}