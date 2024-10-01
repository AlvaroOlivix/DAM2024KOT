package edu.sam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.sam.dam2024.features.movies.domain.GetMovieUseCase
import edu.sam.dam2024.features.movies.domain.Movie


class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {

    //Patron View Model
    fun viewCreated(movieId: String): Movie? {
        return getMovieUseCase.invoke(movieId)
    }


}