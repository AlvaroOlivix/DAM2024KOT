package edu.sam.dam2024.features.movies.presentation

import android.content.Context
import edu.sam.dam2024.features.movies.data.MovieDataRepository
import edu.sam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.sam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.sam.dam2024.features.movies.domain.GetMovieUseCase
import edu.sam.dam2024.features.movies.domain.GetMoviesUseCase

//Una única factoría para cada tipo de clase.
class MovieFactory(private val context: Context) {
    private val movieMockRemoteDataSource = MovieMockRemoteDataSource()
    private val movieLocal = MovieXmlLocalDataSource(context)
    private val movieDataRepository = MovieDataRepository(movieMockRemoteDataSource, movieLocal)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)

    fun buildViewModel(): MoviesViewModel {
        return MoviesViewModel(getMoviesUseCase)
    }

    fun buildMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel(getMovieUseCase)

    }
}