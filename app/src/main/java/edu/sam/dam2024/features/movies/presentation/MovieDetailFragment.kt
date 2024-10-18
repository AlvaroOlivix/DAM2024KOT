package edu.sam.dam2024.features.movies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.sam.dam2024.app.extensions.loadUrl
import edu.sam.dam2024.databinding.FragmentMovieDetailBinding
import edu.sam.dam2024.features.movies.domain.Movie
import edu.sam.dam2024.features.movies.presentation.adapter.MovieAdapter

class MovieDetailFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private val movieArgs: MovieDetailFragmentArgs by navArgs()

    private val movieAdapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildMovieDetailViewModel()

        getMovieId()?.let {
            viewModel.viewCreated(it)
        }
        setUpObserver()

    }

    private fun setUpObserver() {
        val movieDetailObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                //bindData(it)
            }
            uiState.errorApp?.let {
                //pinto error
            }
            if (uiState.isLoading) {
                // Mostrar un indicador de carga
            } else {
                // Ocultar el indicador de carga
            }
        }
    }

    private fun bindData(movie: Movie) {
        binding.apply {
            nameMovie.text = movie.title
            imgMovie.loadUrl(movie.poster)
        }

    }

    private fun getMovieId(): String {
        return movieArgs.movieId
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
