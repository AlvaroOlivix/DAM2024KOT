package edu.sam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.domain.Movie

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val movieId = intent.getStringExtra(KEY_MOVIE_ID)
        viewModel= movieFactory.buildMovieDetailViewModel()

        getMovieId()?.let { moviId ->
            viewModel.viewCreated(moviId)?.let { movie ->
                bindData(movie)
            }
        }



    }

    private fun bindData(movie: Movie) {
    val imageView = findViewById<ImageView>(R.id.movie_poster_3)
    }

    private fun getMovieId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }

    //Funcion estática
    //COn esto creamos la funcion que se usará para acceder a esta vista en otras clases.
    companion object {
        val KEY_MOVIE_ID = "key_movie_id"


        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }
}
