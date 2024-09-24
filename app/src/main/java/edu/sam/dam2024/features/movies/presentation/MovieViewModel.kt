package edu.sam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.sam.dam2024.features.movies.domain.GetMovieUseCase
import edu.sam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.sam.dam2024.features.movies.domain.Movie

//Pinta cosas en la vista segun los datos recibidos a partir de los casos de uso
class MovieViewModel(
    private val getMovieUseCase: GetMoviesUseCase,
    private val getMoviesUseCase: GetMovieUseCase
) : ViewModel() {

    //Patron View Model
    fun viewCreated(): List<Movie> {
        return getMovieUseCase.invoke()
    }

    fun itemSelected(movieId: String): Movie? {
        return getMovieUseCase.invoke(movieId)
    }

}