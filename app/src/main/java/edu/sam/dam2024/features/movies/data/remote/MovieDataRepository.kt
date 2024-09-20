package edu.sam.dam2024.features.movies.data.remote

import edu.sam.dam2024.features.movies.domain.Movie
import edu.sam.dam2024.features.movies.domain.MovieRepository

/*
Naming: Modelo + DataRepository
 */
class MovieDataRepository(private val remoteDataSource: MovieMockRemoteDataSource): MovieRepository {

    //Dame la lista de películas
    override fun getMovies(): List<Movie> {
        TODO("Not yet implemented")
    }

}
