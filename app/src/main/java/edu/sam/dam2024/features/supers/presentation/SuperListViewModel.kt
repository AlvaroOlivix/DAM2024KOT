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

class SuperListViewModel(private val getSupersUseCase: GetSupersUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val superList = getSupersUseCase.invoke()
            _uiState.postValue(UiState(superList = superList))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superList: List<Super>? = null
    )


}