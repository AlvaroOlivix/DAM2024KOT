package edu.sam.dam2024.features.movies.data

import edu.sam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.sam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.sam.dam2024.features.movies.domain.Movie
import edu.sam.dam2024.features.movies.domain.MovieRepository

/*
Naming: Modelo + DataRepository
 */

class MovieDataRepository(
    private val mockRemoteDataSource: MovieMockRemoteDataSource,
    private val local: MovieXmlLocalDataSource
) : MovieRepository {

    override fun getMovies(): List<Movie> {
        val moviesFromLocal = local.findAll()
        if (moviesFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            return moviesFromRemote
        } else {
            return moviesFromLocal
        }
    }


    override fun getMovie(movieId: String): Movie? {
        val localMovie = local.findById(movieId)
        if (localMovie == null) {
            mockRemoteDataSource.getMovie(movieId)?.let {
                local.save(it)
                return it
            }
        }
        return localMovie
    }


}
