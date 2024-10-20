package edu.sam.dam2024.features.movies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.databinding.FragmentMovieListBinding
import edu.sam.dam2024.features.movies.domain.Movie
import edu.sam.dam2024.features.movies.presentation.adapter.MovieAdapter

class MovieListFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    private val movieAdapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildViewModel()
        setUpObserver()
        viewModel.viewCreated()


    }

    private fun setUpObserver() {
        val movieListObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //Pinta el error
                //showError(it)
            } ?: run {
                //Oculta el error
            }
            if (uiState.isLoading) {
                // Mostrar un indicador de carga
            } else {
                // Ocultar el indicador de carga
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, movieListObserver)
    }

    //Antes de crear el setUpView es necesario crear el adapter y sus clases correspondientes.

    private fun setUpView() {
        binding.apply {
            listItemMovie.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            movieAdapter.setOnClick { movieId ->
                navigateToDetail(movieId)
            }
            listItemMovie.adapter = movieAdapter
        }
    }

    private fun bindData(movieList: List<Movie>) {
        movieAdapter.submitList(movieList)
    }


    private fun navigateToDetail(movieId: String) {
        findNavController().navigate(
            MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(movieId)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


