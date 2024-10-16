package edu.sam.dam2024.features.movies.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.presentation.factory.MovieFactory
import edu.sam.dam2024.features.movies.presentation.viewModel.MovieListViewModel

class MoviesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

    }
}
