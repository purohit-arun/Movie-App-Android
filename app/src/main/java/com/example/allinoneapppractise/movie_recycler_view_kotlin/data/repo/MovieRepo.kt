package com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repo

import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDao

class MovieRepo(private val dao: MovieDao) {

    val moviesList = dao.getAllMovies()

    suspend fun insertMovie(movie: Movie):Long {
        return dao.insertMovie(movie)
    }

    suspend fun updateMovie(movie: Movie): Int {
        return dao.updateMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie): Int {
        return dao.deleteMovie(movie)
    }

    suspend fun getMovies() {
        dao.getAllMovies()
    }
}