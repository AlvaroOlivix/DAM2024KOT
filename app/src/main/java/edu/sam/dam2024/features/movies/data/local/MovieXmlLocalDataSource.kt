package edu.sam.dam2024.features.movies.data.local

import android.annotation.SuppressLint
import android.content.Context
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.domain.Movie

// Naming : Modelo + Tecnología (Ficheros XML) + LocalDataSource
class MovieXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )
    fun save(movie: Movie) {
        /* Forma en java
        val editor = sharedPref.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()
         */
        //Forma en kotlin
        sharedPref.edit().apply {
            putString("id", movie.id)
            putString("title", movie.title)
            putString("poster", movie.poster)
            apply()
        }
    }
    fun saveAll(movies: List<Movie>) {
        val editor = sharedPref.edit()
        movies.forEach{ movie ->
            editor.putString(movie.id, movie.title )

        }
    }
    fun findMovie(): Movie {
        /*
        //Forma en java

        val id = sharedPref.getString("id", " ")
        val title = sharedPref.getString("title", " ")
        val poster = sharedPref.getString("poster", " ")
        return Movie(id!!, title!!, poster!!)
        */
        //Forma en kotlin
        sharedPref.apply {
            return Movie(
                getString("id", " ")!!,
                getString("title", " ")!!,
                getString("poster", " ")!!
            )
        }
    }
    @SuppressLint("CommitPrefEdits")
    fun delete() {
        sharedPref.edit().clear()
    }
}