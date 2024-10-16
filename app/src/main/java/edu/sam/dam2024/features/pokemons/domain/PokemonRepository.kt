package edu.sam.dam2024.features.pokemons.domain

import edu.sam.dam2024.features.pokemons.domain.models.Pokemon

interface PokemonRepository {
    fun getPokemon(pokemonId: String): Pokemon?
    fun getPokemonList(): List<Pokemon>
}