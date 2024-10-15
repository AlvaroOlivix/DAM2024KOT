package edu.sam.dam2024.features.pokemons.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.sam.dam2024.R
import edu.sam.dam2024.features.pokemons.domain.models.Pokemon

class PokemonAdapter : ListAdapter<Pokemon, PokemonViewHolder>(PokemonDiffUtil()) {

    private lateinit var onClick: (String) -> Unit

    fun setOnClick(onClick: (String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }


}
