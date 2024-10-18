package edu.sam.dam2024.features.movies.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.sam.dam2024.app.extensions.loadUrl
import edu.sam.dam2024.databinding.ViewMovieItemBinding
import edu.sam.dam2024.features.movies.domain.Movie

class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var binding: ViewMovieItemBinding

    fun bind(movie: Movie, onClick: (String) -> Unit) {
        binding = ViewMovieItemBinding.bind(view)

        binding.apply {
            movieImage.loadUrl(movie.poster)
            movieName.text = movie.title
            view.setOnClickListener {
                onClick(movie.id)
            }
        }
    }


}