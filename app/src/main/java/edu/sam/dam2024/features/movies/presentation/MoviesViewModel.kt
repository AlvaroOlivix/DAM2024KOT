package edu.sam.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.sam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Pinta cosas en la vista segun los datos recibidos a partir de los casos de uso
class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    //Patrón observer (Observable)
    fun viewCreated() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = getMoviesUseCase.invoke()

            _uiState.postValue(UiState(movies = movies))
        }
    }

    //Modelo UI, aqui se declaran los estados en los que se encuentra la aplicacion
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movies: List<Movie>? = null
    )
}