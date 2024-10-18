package edu.sam.dam2024.features.pokemons.data.remote

import edu.sam.dam2024.features.pokemons.domain.models.Pokemon

class PokemonMockRemoteDataSource {

    private val pokemonList = listOf(
        Pokemon("1", "Bulbasaur", "100", "https://example.com/bulbasaur.jpg"),
        Pokemon("2", "Charmander", "90", "https://example.com/charmander.jpg"),
        Pokemon("3", "Squirtle", "80", "https://example.com/squirtle.jpg")
    )

    fun getPokemonList(): List<Pokemon> {
        return pokemonList
    }

    fun getPokemon(pokemonId: String): Pokemon? {
        return pokemonList.find { it.id == pokemonId }
    }
}