package edu.sam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private val movieFactory: MovieFactory = MovieFactory()
    private val viewModel = movieFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movies = viewModel.viewCreated()
        bindData(movies)

        // FFF
        viewModel.itemSelected(movies.first().id)
        // FFF
    }

    private fun bindData(movies: List<Movie>) {
        // val textView_1 = findViewById<TextView>(R.id.movie_id_1)

        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layaout_1).setOnClickListener {
           val movie1: Movie? = viewModel.itemSelected(movies[0].id)
            movie1?.let {
                Log.d("@dev", "Pelicula Seleccionada: ${it.title}")
                // $it Imprime el objeto entero
            }
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_id_2).text = movies[1].title

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_id_3).text = movies[2].title
    }


    override fun onStart() {
        super.onStart()
        Log.d("@dev", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@dev", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@dev", "onPause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@dev", "onDestroy")
    }
}
