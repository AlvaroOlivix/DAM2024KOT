package edu.sam.dam2024.features.pokemons.presentation.factory

import android.content.Context
import edu.sam.dam2024.features.pokemons.data.PokemonDataRepository
import edu.sam.dam2024.features.pokemons.data.local.PokemonXmlLocalDataSource
import edu.sam.dam2024.features.pokemons.data.remote.PokemonMockRemoteDataSource
import edu.sam.dam2024.features.pokemons.domain.usecases.GetPokemonListUseCase
import edu.sam.dam2024.features.pokemons.domain.usecases.GetPokemonUseCase
import edu.sam.dam2024.features.pokemons.presentation.viewmodel.PokemonDetailViewModel
import edu.sam.dam2024.features.pokemons.presentation.viewmodel.PokemonListViewModel

class PokemonFactory(private val context: Context){
    private val pokemonRemote = PokemonMockRemoteDataSource()
    private val pokemonLocal = PokemonXmlLocalDataSource(context)
    private val pokemonDataRepository = PokemonDataRepository(pokemonLocal, pokemonRemote)
    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)
    private val getPokemonListUseCase = GetPokemonListUseCase(pokemonDataRepository)

    fun buildPokemonListViewModel(): PokemonListViewModel {
        return PokemonListViewModel(getPokemonListUseCase)
    }

    fun buildPokemonDetailViewModel(): PokemonDetailViewModel {
        return PokemonDetailViewModel(getPokemonUseCase)
    }
}