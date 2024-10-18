package edu.sam.dam2024.features.pokemons.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.sam.dam2024.app.extensions.loadUrl
import edu.sam.dam2024.databinding.FragmentPokemonDetailBinding
import edu.sam.dam2024.features.pokemons.domain.models.Pokemon
import edu.sam.dam2024.features.pokemons.presentation.factory.PokemonFactory
import edu.sam.dam2024.features.pokemons.presentation.viewmodel.PokemonDetailViewModel

class PokemonDetailFragment : Fragment() {

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonDetailViewModel

    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private val pokemonArgs: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildPokemonDetailViewModel()

        getPokemonId()?.let {
            viewModel.loadPokemonDetail(it)
        }
        setUpObserver()
    }

    private fun setUpObserver() {

        val pokemonDetailObserver = Observer<PokemonDetailViewModel.UiState> { uiState ->
            uiState.pokemon?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto error
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Loading...")
            } else {
                Log.d("@dev", "Loaded")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, pokemonDetailObserver)
    }

    private fun bindData(pokemon: Pokemon) {

        binding.apply {
            namePokemon.text = pokemon.name
            powerPokemon.text = pokemon.power.toString()
            imgPokemon.loadUrl(pokemon.image)
        }
    }

    private fun getPokemonId(): String {
        return pokemonArgs.pokemonId
    }
}
