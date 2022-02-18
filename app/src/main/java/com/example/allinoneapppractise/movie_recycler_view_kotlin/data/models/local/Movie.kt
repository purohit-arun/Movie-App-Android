package com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    val id: Int,

    @ColumnInfo(name = "movie_name")
    var movie_name: String,

    @ColumnInfo(name = "release_date")
    var release_date: String,

    @ColumnInfo(name = "movie_rating")
    var rating: String,

    @ColumnInfo(name = "movie_image")
    var movie_image: String
):Serializable