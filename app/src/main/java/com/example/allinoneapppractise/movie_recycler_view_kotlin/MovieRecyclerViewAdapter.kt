package com.example.allinoneapppractise.movie_recycler_view_kotlin

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.movie_recycler_view_kotlin.db.Movie

class MovieRecyclerViewAdapter(val context: Context) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder>() {

    //this list hold the list of movies
    val movieList = ArrayList<Movie>()


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val posterImage = itemView.findViewById<ImageView>(R.id.poster_iv)
        val movieName = itemView.findViewById<TextView>(R.id.movie_name_tv)
        val movieReleaseDate = itemView.findViewById<TextView>(R.id.release_date_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_movie_2, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMovie = movieList[position]
        holder.movieName.text = currentMovie.movie_name
        holder.movieReleaseDate.text = currentMovie.release_date
//        holder.posterImage.setImageResource(currentMovie.mImageDrawable)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setListOfMovie(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
}