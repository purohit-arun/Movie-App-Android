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
import com.example.allinoneapppractise.custom_movie_array_adapter_kotlin.Movie

class MovieRecyclerViewAdapter(val context: Context, val mList: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder>() {

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
        val currentMovie = mList[position]
        holder.movieName.text = currentMovie.mName
        holder.movieReleaseDate.text = currentMovie.mRelease
//        holder.posterImage.setImageResource(currentMovie.mImageDrawable)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}