package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.MovieItemBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie

class MovieRecyclerViewAdapter(
    val context: Context,
    private val clickListener: (Movie) -> Unit,
    private val onLongClickListener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder>() {

    private val movieList: ArrayList<Movie> = arrayListOf()

    fun setListOfMovie(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, clickListener: (Movie) -> Unit, onLongClickListener: (Movie) -> Unit) {
            binding.movieNameTv.text = movie.movie_name
            binding.releaseDateTv.text = movie.release_date
            binding.movieIv.load(movie.movie_image)
            binding.listItemLayout.setOnClickListener {
                clickListener(movie)
            }
            binding.listItemLayout.setOnLongClickListener {
                onLongClickListener(movie)
                true
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
        val currentMovie = movieList[position]
        holder.bind(currentMovie, clickListener,onLongClickListener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
