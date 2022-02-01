package com.example.retrofitdemo.retrofit_practise.movie_data_classes

data class Schedule(
    var days: List<String>? = listOf(),
    var time: String? = ""
)