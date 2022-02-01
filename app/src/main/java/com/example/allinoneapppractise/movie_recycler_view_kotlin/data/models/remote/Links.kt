package com.example.retrofitdemo.retrofit_practise.movie_data_classes

data class Links(
    var previousepisode: Previousepisode? = Previousepisode(),
    var self: Self? = Self()
)