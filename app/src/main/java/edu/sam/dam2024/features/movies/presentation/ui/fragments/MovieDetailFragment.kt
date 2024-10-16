package edu.sam.dam2024.features.movies.presentation.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.sam.dam2024.app.domain.ErrorApp
import edu.sam.dam2024.databinding.FragmentMovieDetailBinding

import edu.sam.dam2024.features.movies.domain.model.Movie
import edu.sam.dam2024.features.movies.presentation.factory.MovieFactory
import edu.sam.dam2024.features.movies.presentation.viewModel.MovieDetailViewModel

class MovieDetailFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMovieDetailBinding? = null
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

    }

    private fun setupObserver() {
        val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                //bindData(it)
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
    }

    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailFragment::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
