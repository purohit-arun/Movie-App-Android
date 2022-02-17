package com.example.retrofitdemo.retrofit_practise

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MovieRetrofitInstance {
    companion object {
        const val BASE_URL = "https://api.tvmaze.com/"
        /*fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }*/

    }
}