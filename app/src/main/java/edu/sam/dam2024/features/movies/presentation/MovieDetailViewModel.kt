package edu.sam.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.features.movies.domain.GetMovieUseCase
import edu.sam.dam2024.features.movies.domain.Movie
import edu.sam.dam2024.features.movies.presentation.MoviesViewModel.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    //Patrón observer (Observable)
    fun viewCreated(id:String) {
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val movie = getMovieUseCase.invoke(id)
            _uiState.postValue(UiState(movie = movie))
        }
    }
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movie: Movie? = null
    )
}