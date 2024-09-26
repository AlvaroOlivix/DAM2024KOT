package edu.sam.dam2024.features.movies.presentation

import edu.sam.dam2024.features.movies.data.MovieDataRepository
import edu.sam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.sam.dam2024.features.movies.domain.GetMovieUseCase
import edu.sam.dam2024.features.movies.domain.GetMoviesUseCase

class MovieFactory {
    fun buildViewModel(): MovieViewModel =
        MovieViewModel(GetMovieUseCase(MovieDataRepository(MovieMockRemoteDataSource())),
            GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource()))
        )

}