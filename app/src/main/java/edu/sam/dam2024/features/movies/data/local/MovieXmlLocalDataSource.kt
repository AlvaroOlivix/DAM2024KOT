package edu.sam.dam2024.features.movies.data.local

import android.annotation.SuppressLint
import android.content.Context
import com.google.gson.Gson
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.domain.Movie

// Naming : Modelo + Tecnología (Ficheros XML) + LocalDataSource
class MovieXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )
    private val gson = Gson()

    fun save(movie: Movie) {
        val editor = sharedPref.edit()
        editor.putString(movie.id, gson.toJson(movie))
        editor.apply()
    }


    fun saveAll(movies: List<Movie>) {
        val editor = sharedPref.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()

    }

    fun findAll(): List<Movie> {
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

    fun findById(movieId: String): Movie? {
        return sharedPref.getString(movieId, null)?.let { jsonMovie ->
            gson.fromJson(jsonMovie, Movie::class.java)
        }
    }


    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun delete(movieId: String) {
        sharedPref.edit().remove(movieId).apply()
    }

}