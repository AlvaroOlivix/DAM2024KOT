package edu.sam.dam2024.features.movies.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.sam.dam2024.features.movies.domain.Movie

class MoviesActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private val viewModel = movieFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        val movies = viewModel.viewCreated()
        bindData(movies)

        // FFF
        viewModel.itemSelected(movies.first().id)
        // FFF

        testxml()
    }

    private fun testxml() {
        val xmlDataSource = MovieXmlLocalDataSource(this)
        val movie = viewModel.itemSelected("1")
        movie?.let {
            xmlDataSource.save(it)
        }
        val movieSaved = xmlDataSource.findMovie()
        Log.d("@dev", movieSaved.toString())

        xmlDataSource.delete()
    }

    private fun bindData(movies: List<Movie>) {
        // val textView_1 = findViewById<TextView>(R.id.movie_id_1)
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].title
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].poster
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToMovieDetail(movies[0].id)
        }
        findViewById<TextView>(R.id.movie_id_2).text = movies[0].id
        findViewById<TextView>(R.id.movie_id_2).text = movies[0].title
        findViewById<TextView>(R.id.movie_id_2).text = movies[0].poster
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToMovieDetail(movies[0].id)
        }
        findViewById<TextView>(R.id.movie_id_3).text = movies[0].id
        findViewById<TextView>(R.id.movie_id_3).text = movies[0].title
        findViewById<TextView>(R.id.movie_id_3).text = movies[0].poster
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToMovieDetail(movies[0].id)
        }
    }
private fun navigateToMovieDetail(movieId: String) {
    startActivity(MovieDetailActivity.getIntent(this, movieId))

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
