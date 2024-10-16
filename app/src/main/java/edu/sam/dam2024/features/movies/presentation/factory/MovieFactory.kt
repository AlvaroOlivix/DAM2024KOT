package edu.sam.dam2024.features.movies.presentation.factory

import android.content.Context
import edu.sam.dam2024.features.movies.data.MovieDataRepository
import edu.sam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.sam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.sam.dam2024.features.movies.domain.usecases.GetMovieUseCase
import edu.sam.dam2024.features.movies.domain.usecases.GetMoviesUseCase
import edu.sam.dam2024.features.movies.presentation.viewModel.MovieDetailViewModel
import edu.sam.dam2024.features.movies.presentation.viewModel.MovieListViewModel

//Una única factoría para cada tipo de clase.
class MovieFactory(private val context: Context) {
    private val movieMockRemoteDataSource = MovieMockRemoteDataSource()
    private val movieLocal = MovieXmlLocalDataSource(context)
    private val movieDataRepository = MovieDataRepository(movieMockRemoteDataSource, movieLocal)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)

    fun buildViewModel(): MovieListViewModel {
        return MovieListViewModel(getMoviesUseCase)
    }

    fun buildMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel(getMovieUseCase)

    }
}