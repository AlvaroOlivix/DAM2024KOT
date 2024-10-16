package edu.sam.dam2024.features.movies.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.databinding.FragmentMovieDetailBinding
import edu.sam.dam2024.databinding.FragmentMovieListBinding
import edu.sam.dam2024.features.movies.domain.model.Movie
import edu.sam.dam2024.features.movies.presentation.factory.MovieFactory
import edu.sam.dam2024.features.movies.presentation.viewModel.MovieListViewModel

class MovieListFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieListViewModel
    //Esta info se encuentra en https://developer.android.com/topic/libraries/view-binding?hl=es-419#kts

    //Se crea despues de que se creen los XML de cada clase
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildViewModel()
        viewModel.viewCreated()

    }

    private fun setupObserver() {
        val movieObserver = Observer<MovieListViewModel.UiState> { uiState ->
            uiState.movies?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //error
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Loading...")
            } else {
                Log.d("@dev", "Loading...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }

    private fun bindData(movies: List<Movie>) {
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknownErrorAPp -> TODO()
        }
    }

    private fun navigateToMovieDetail(movieId: String) {
        startActivity(MovieDetailFragment.getIntent(requireContext(), movieId))
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}