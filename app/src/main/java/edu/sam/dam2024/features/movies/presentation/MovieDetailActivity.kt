package edu.sam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.domain.Movie
import edu.sam.dam2024.app.extensions.loadUrl

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        enableEdgeToEdge()

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildMovieDetailViewModel()


        getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)
        }
        setupObserver()
    }

    private fun setupObserver() {
        val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Loading...")
            } else {
                Log.d("@dev", "Loading...")
            }
        }
        viewModel.uiState.observe(this, movieObserver)
    }

    private fun getMovieId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }

    private fun bindData(movie: Movie) {
        val imageView = findViewById<ImageView>(R.id.movie_poster_1)
        imageView.loadUrl(movie.poster)
    }

    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }
}
