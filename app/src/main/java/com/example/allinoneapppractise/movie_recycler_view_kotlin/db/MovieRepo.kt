package com.example.allinoneapppractise.movie_recycler_view_kotlin.db

class MovieRepo(private val dao: MovieDao) {

    suspend fun insertMovie(movie: Movie) {
        dao.insertMovie(movie)
    }

    suspend fun updateMovie(movie: Movie) {
        dao.updateMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie) {
        dao.deleteMovie(movie)
    }

}