package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repository.MovieRepo
import java.lang.IllegalArgumentException
import javax.inject.Inject

class MovieViewModelFactory @Inject constructor(private val repository: MovieRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieActivityViewModel::class.java)) {
            return MovieActivityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}