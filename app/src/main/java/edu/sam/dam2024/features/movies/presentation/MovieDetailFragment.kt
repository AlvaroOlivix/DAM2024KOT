package edu.sam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import edu.sam.dam2024.app.domain.ErrorApp

class MovieDetailFragment : Fragment() {

    //Esta info se encuentra en https://developer.android.com/topic/libraries/view-binding?hl=es-419#kts


    companion object {

        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailFragment::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }

}
