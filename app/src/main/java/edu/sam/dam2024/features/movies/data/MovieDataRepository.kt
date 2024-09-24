package edu.sam.dam2024.features.movies.data

import edu.sam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.sam.dam2024.features.movies.domain.Movie
import edu.sam.dam2024.features.movies.domain.MovieRepository

/*
Naming: Modelo + DataRepository
 */

class MovieDataRepository(private val mockRemoteDataSource: MovieMockRemoteDataSource) :
    MovieRepository {
    //Dame la lista de películas

        override fun getMovies(): List<Movie> {
            return mockRemoteDataSource.getMovies()
        }

    override fun getMovie(movieId: String): Movie? {
        return mockRemoteDataSource.getMovie(movieId)
    }


}
