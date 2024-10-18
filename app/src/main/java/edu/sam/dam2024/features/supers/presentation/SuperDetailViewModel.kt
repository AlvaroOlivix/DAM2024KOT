package edu.sam.dam2024.features.supers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.features.supers.domain.GetSuperUseCase
import edu.sam.dam2024.features.supers.domain.Super
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperDetailViewModel(private val getSuperUseCase: GetSuperUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated(superId: String) {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val sup = getSuperUseCase.invoke(superId)
            _uiState.postValue(UiState(sup = sup))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val sup: Super? = null
    )
}