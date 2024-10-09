package edu.sam.dam2024.features.supers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.features.supers.domain.GetSupersUseCase
import edu.sam.dam2024.features.supers.domain.Super
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SupersListViewModel(private val getSupersUseCase: GetSupersUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    //Se instancia de tipo LiveData para proteger ciertos métodos de su cambio.
    val uiState: LiveData<UiState> = _uiState

    //Cargame la lista de datos
    fun loadSupers() {
        viewModelScope.launch(Dispatchers.IO) {
            val supersList = getSupersUseCase.invoke()
            UiState(supersList = supersList)
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val supersList: List<Super>? = null)
}