package com.example.allinoneapppractise.custom_movie_array_adapter_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.allinoneapppractise.R
import java.util.ArrayList

class MovieAdapter(private val mContext: Context, private val movieList: ArrayList<Movie>) :
    ArrayAdapter<Movie>(mContext, 0, movieList) {
    lateinit var moviePosterImageView: ImageView
    lateinit var nameTextView: TextView
    lateinit var releaseTextView: TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItem = convertView
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext)
                .inflate(R.layout.list_item_movie, parent, false)

            val currentMovie = movieList.get(position)

            moviePosterImageView = listItem.findViewById(R.id.poster_iv)
            nameTextView = listItem.findViewById(R.id.movie_name_tv)
            releaseTextView = listItem.findViewById(R.id.release_tv)


            moviePosterImageView.setImageResource(currentMovie.mImageDrawable!!)
            nameTextView.text = currentMovie.mName
            releaseTextView.text = currentMovie.mRelease

        }
        return listItem!!
    }
}