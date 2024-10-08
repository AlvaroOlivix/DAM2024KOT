package edu.sam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.sam.dam2024.R
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.app.extensions.loadUrl
import edu.sam.dam2024.databinding.FragmentMoviesBinding
import edu.sam.dam2024.features.movies.domain.Movie

class MovieDetailFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel
    //Esta info se encuentra en https://developer.android.com/topic/libraries/view-binding?hl=es-419#kts

    //El guión significa que nos crearemos una variable con el mismo nombre
    private var _binding: FragmentMoviesBinding? = null

    // Las !! ignora el nulo
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildViewModel()
        viewModel.viewCreated()

    }

    private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
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
        binding.movieId1.text = movies[0].id
        binding.movieTitle1.text = movies[0].title
        binding.layout1.setOnClickListener {
            findNavController()
        }
        binding.movieId2.text = movies[1].id
        binding.movieTitle2.text = movies[1].title
        binding.layout2.setOnClickListener {
            findNavController()
        }
        binding.movieId3.text = movies[2].id
        binding.movieTitle3.text = movies[2].title
        binding.layout3.setOnClickListener {
            findNavController()
        }

        binding.movieId4.text = movies[3].id
        binding.movieTitle4.text = movies[3].title
        binding.layout4.setOnClickListener {
            findNavController()
        }

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
        startActivity(MovieDetailActivity.getIntent(requireContext(), movieId))

    }
    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
