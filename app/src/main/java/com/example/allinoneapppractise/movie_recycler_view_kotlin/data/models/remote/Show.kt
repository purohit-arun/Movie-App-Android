package com.example.retrofitdemo.retrofit_practise.movie_data_classes

data class Show(
    var id: Int? = 0,
    var name: String? = "",
    var image: Image? = Image(),
    var premiered: String? = "",
    var rating: Rating? = Rating(),
)