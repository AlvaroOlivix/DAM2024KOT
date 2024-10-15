package edu.sam.dam2024.features.pokemons.data

import edu.sam.dam2024.features.pokemons.data.local.PokemonXmlLocalDataSource
import edu.sam.dam2024.features.pokemons.data.remote.PokemonMockRemoteDataSource
import edu.sam.dam2024.features.pokemons.domain.models.Pokemon
import edu.sam.dam2024.features.pokemons.domain.repository.PokemonRepository

class PokemonDataRepository(
    private val localDataSource: PokemonXmlLocalDataSource,
    private val remoteDataSource: PokemonMockRemoteDataSource
) : PokemonRepository {

    override fun getPokemonList(): List<Pokemon> {
        val pokemonListFromLocal = localDataSource.findAll()
        if (pokemonListFromLocal.isEmpty()) {
            val pokemonListFromRemote = remoteDataSource.getPokemonList()
            localDataSource.saveAll(pokemonListFromRemote)
            return pokemonListFromRemote
        } else {
            return pokemonListFromLocal
        }
    }

    override fun getPokemon(pokemonId: String): Pokemon? {
        val pokemonFromLocal = localDataSource.findById(pokemonId)
        if (pokemonFromLocal == null) {
            remoteDataSource.getPokemon(pokemonId)?.let {
                localDataSource.save(it)
                return it
            }
        }
        return pokemonFromLocal
    }
}