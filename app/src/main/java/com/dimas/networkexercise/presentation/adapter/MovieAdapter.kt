package com.dimas.networkexercise.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dimas.networkexercise.databinding.ItemTransactionBinding
import com.dimas.networkexercise.domain.model.Movie
import com.dimas.networkexercise.domain.model.Transaction

class MovieAdapter(
    private val context: Context,
    private val items: MutableList<Movie>
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(data: List<Movie>) {
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: ItemTransactionBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Movie) {
            with(binding) {
                Glide.with(context).load(data.image).into(imageMovie)
                textTitle.text = data.title
                textDesc.text = data.desc
                textDate.text = data.releaseDate
            }
        }

    }
}