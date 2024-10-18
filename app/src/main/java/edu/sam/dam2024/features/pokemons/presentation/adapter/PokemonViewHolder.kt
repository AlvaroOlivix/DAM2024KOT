package edu.sam.dam2024.features.pokemons.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.sam.dam2024.app.extensions.loadUrl
import edu.sam.dam2024.databinding.ViewPokemonItemBinding
import edu.sam.dam2024.features.pokemons.domain.models.Pokemon

class PokemonViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var binding: ViewPokemonItemBinding

    fun bind(pokemon: Pokemon, onClick: (String) -> Unit) {
        binding = ViewPokemonItemBinding.bind(view)

        binding.apply {
            pokemonName.text = pokemon.name
            pokemonDesc.text = pokemon.power
            pokemonImage.loadUrl(pokemon.image)
            view.setOnClickListener {
                onClick(pokemon.id)
            }
        }
    }
}