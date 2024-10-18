package edu.sam.dam2024.features.movies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.sam.dam2024.R
import edu.sam.dam2024.features.movies.domain.Movie

class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieDiffUtil()) {
    private lateinit var onClick: (String) -> Unit

    fun setOnClick(onClick: (String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }

    override fun getItemCount(): Int = currentList.size


}