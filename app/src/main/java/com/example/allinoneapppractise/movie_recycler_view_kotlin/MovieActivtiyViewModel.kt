package com.example.allinoneapppractise.movie_recycler_view_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allinoneapppractise.movie_recycler_view_kotlin.db.Movie
import com.example.allinoneapppractise.movie_recycler_view_kotlin.db.MovieRepo
import kotlinx.coroutines.launch

class MovieActivtiyViewModel(private val repository: MovieRepo) : ViewModel() {

    val inputMovie = MutableLiveData<String>()
    val inputReleaseDate = MutableLiveData<String>()

    fun insertMovie() = viewModelScope.launch {
        val moviename = inputMovie.value!!
        val releaseDate = inputReleaseDate.value!!
        repository.insertMovie(Movie(0, moviename, releaseDate))
    }


}