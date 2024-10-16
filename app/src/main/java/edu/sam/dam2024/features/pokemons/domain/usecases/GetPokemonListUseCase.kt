package edu.sam.dam2024.features.pokemons.domain.usecases

import edu.sam.dam2024.features.pokemons.domain.models.Pokemon
import edu.sam.dam2024.features.pokemons.domain.PokemonRepository

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) {

    operator fun invoke(): List<Pokemon> {
        return pokemonRepository.getPokemonList()
    }

}