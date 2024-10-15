package edu.sam.dam2024.features.pokemons.domain.usecases

import edu.sam.dam2024.features.pokemons.domain.models.Pokemon
import edu.sam.dam2024.features.pokemons.domain.repository.PokemonRepository

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {

    operator fun invoke(pokemonId: String): Pokemon? {
        return pokemonRepository.getPokemon(pokemonId)
    }
}