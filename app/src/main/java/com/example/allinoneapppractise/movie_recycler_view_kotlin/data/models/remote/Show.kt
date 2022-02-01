package com.example.retrofitdemo.retrofit_practise.movie_data_classes

data class Show(
    var _links: Links? = Links(),
    var averageRuntime: Int? = 0,
    var dvdCountry: Any? = Any(),
    var ended: String? = "",
    var externals: Externals? = Externals(),
    var genres: List<String>? = listOf(),
    var id: Int? = 0,
    var image: Image? = Image(),
    var language: String? = "",
    var name: String? = "",
    var network: Network? = Network(),
    var officialSite: String? = "",
    var premiered: String? = "",
    var rating: Rating? = Rating(),
    var runtime: Int? = 0,
    var schedule: Schedule? = Schedule(),
    var status: String? = "",
    var summary: String? = "",
    var type: String? = "",
    var updated: Int? = 0,
    var url: String? = "",
    var webChannel: Any? = Any(),
    var weight: Int? = 0
)