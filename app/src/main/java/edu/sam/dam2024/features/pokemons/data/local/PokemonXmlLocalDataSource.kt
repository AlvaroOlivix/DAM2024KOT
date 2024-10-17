package edu.sam.dam2024.features.pokemons.data.local

import android.content.Context
import com.google.gson.Gson
import edu.sam.dam2024.R
import edu.sam.dam2024.features.pokemons.domain.models.Pokemon

class PokemonXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_filePokemon_xml), Context.MODE_PRIVATE
    )
    private val gson = Gson()

    fun save(pokemon: Pokemon) {
        val editor = sharedPref.edit()
        editor.putString(pokemon.id, gson.toJson(pokemon))
        editor.apply()
    }

    fun saveAll(pokemonList: List<Pokemon>) {
        val editor = sharedPref.edit()
        pokemonList.forEach { pokemon ->
            editor.putString(pokemon.id, gson.toJson(pokemon))
        }
        editor.apply()
    }

    fun findAll(): List<Pokemon> {
        val pokemonList = ArrayList<Pokemon>()
        val mapPokemon = sharedPref.all
        mapPokemon.values.forEach { jsonPokemon ->
            val pokemon = gson.fromJson(jsonPokemon as String, Pokemon::class.java)
            pokemonList.add(pokemon)
        }
        return pokemonList
    }

    fun findById(pokemonId: String): Pokemon? {
        return sharedPref.getString(pokemonId, null)?.let { jsonPokemon ->
            gson.fromJson(jsonPokemon, Pokemon::class.java)
        }
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun delete(pokemonId: String) {

    }

}
