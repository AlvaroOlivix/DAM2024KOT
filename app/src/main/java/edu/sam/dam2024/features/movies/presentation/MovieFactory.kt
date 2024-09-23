package edu.sam.dam2024.features.movies.presentation

import edu.sam.dam2024.features.movies.data.remote.MovieDataRepository
import edu.sam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.sam.dam2024.features.movies.domain.GetMovieUseCase

class MovieFactory {
    fun buildViewModel(): MovieViewModel =
        MovieViewModel(GetMovieUseCase(MovieDataRepository(MovieMockRemoteDataSource())))

}