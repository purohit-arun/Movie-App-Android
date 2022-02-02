package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ListItemMovie2Binding
import com.example.allinoneapppractise.databinding.MovieItemBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie

class MovieRecyclerViewAdapter(
    val context: Context,
    private val clickListener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder>() {

    private val movieList: ArrayList<Movie>? = null

    fun setListOfMovie(movies: List<Movie>) {
        movieList?.clear()
        movieList?.addAll(movies)
        notifyDataSetChanged()
    }


    class MyViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, clickListener: (Movie) -> Unit) {
            binding.movieNameTv.text = movie.movie_name
            binding.releaseDateTv.text = movie.release_date
            binding.listItemLayout.setOnClickListener {
                clickListener(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MovieItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.movie_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMovie = movieList?.get(position)
        if (currentMovie != null) {
            holder.bind(currentMovie, clickListener)
        }
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }


}

//TODO: 1 Functionality -> Long press the movie list item to delete the movie from the list