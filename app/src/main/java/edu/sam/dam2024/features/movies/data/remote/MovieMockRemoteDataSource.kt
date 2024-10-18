package edu.sam.dam2024.features.movies.data.remote

import edu.sam.dam2024.features.movies.domain.Movie

/*
   Naming: Modelo + Tecnología + RemoteDataSource
 */
class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie(
            "1",
            "title1",
            "https://www.feelcats.com/wp-content/uploads/2018/06/gato-lykoi-03.jpg"
        ),
        Movie(
            "2",
            "title2",
            "https://th.bing.com/th/id/OIP.QaRPvfeYAIB2B3uJ0WPGHAHaE8?rs=1&pid=ImgDetMain"
        ),
        Movie(
            "3",
            "title3",
            "https://www.thesprucepets.com/thmb/0GwOLF6djJKgSdcv1Df9etFteyY=/2119x0/filters:no_upscale():strip_icc()/GettyImages-1184479027-8a7212a5c4fe411abfb1941479f3391d.jpg"
        ),
        Movie(
            title = "title4", poster = "poster4", id = "4"
        )
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull { movie -> movie.id == movieId }


    }
}