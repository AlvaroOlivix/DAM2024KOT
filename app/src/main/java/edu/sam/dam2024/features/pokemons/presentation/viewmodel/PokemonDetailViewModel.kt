package edu.sam.dam2024.features.pokemons.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.features.pokemons.domain.models.Pokemon
import edu.sam.dam2024.features.pokemons.domain.usecases.GetPokemonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val getPokemonUseCase: GetPokemonUseCase)
    : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadPokemonDetail(pokemonId: String) {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val pokemon = getPokemonUseCase.invoke(pokemonId)
            _uiState.value = UiState(pokemon = pokemon)
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemon: Pokemon? = null
    )
}