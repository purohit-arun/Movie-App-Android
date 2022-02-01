package com.example.retrofitdemo.retrofit_practise.movie_data_classes

data class MoviesItem(
    var score: Double? = 0.0,
    var show: Show? = Show()
)