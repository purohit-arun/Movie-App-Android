package com.example.retrofitdemo.retrofit_practise.movie_data_classes

data class Network(
    var country: Country? = Country(),
    var id: Int? = 0,
    var name: String? = ""
)