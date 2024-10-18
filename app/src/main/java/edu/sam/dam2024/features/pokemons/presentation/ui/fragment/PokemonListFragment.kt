package edu.sam.dam2024.features.pokemons.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.databinding.FragmentPokemonListBinding
import edu.sam.dam2024.features.pokemons.domain.models.Pokemon
import edu.sam.dam2024.features.pokemons.presentation.adapter.PokemonAdapter
import edu.sam.dam2024.features.pokemons.presentation.factory.PokemonFactory
import edu.sam.dam2024.features.pokemons.presentation.viewmodel.PokemonListViewModel

class PokemonListFragment : Fragment() {

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonListViewModel

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private val pokemonAdapter = PokemonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildPokemonListViewModel()
        setUpObserver()
        viewModel.loadPokemonList()

    }

    private fun setUpObserver() {
        val pokemonListObserver = Observer<PokemonListViewModel.UiState> { uiState ->
            uiState.pokemonList?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //Pinta el error
                showError(it)
            } ?: run {
                //Oculta el error
            }
            if (uiState.isLoading) {
                // Mostrar un indicador de carga
                Log.d("@dev", "Loading...")
            } else {
                // Ocultar el indicador de carga
                Log.d("@dev", "Loaded")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, pokemonListObserver)
    }

    private fun setUpView() {
        binding.apply {
            listPokemon.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            pokemonAdapter.setOnClick { pokemonId ->
                navigateToDetail(pokemonId)
            }
            listPokemon.adapter = pokemonAdapter
        }
    }

    private fun bindData(pokemonList: List<Pokemon>) {
        pokemonAdapter.submitList(pokemonList)
    }

    private fun showError(errorApp: ErrorApp) {
        // Handle error
    }

    private fun navigateToDetail(pokemonId: String) {
        findNavController().navigate(
            PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(pokemonId)

        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}