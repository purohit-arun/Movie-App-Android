package com.example.retrofitdemo.retrofit_practise

import android.graphics.Movie
import com.example.retrofitdemo.retrofit_practise.movie_data_classes.Movies
import com.example.retrofitdemo.retrofit_practise.movie_data_classes.MoviesItem
import com.example.retrofitdemo.retrofit_practise.movie_data_classes.Show
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("/shows")
    suspend fun getShows(): Response<List<Show>>
}