package com.example.mvvmretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofit.databinding.CardMemeBinding
import com.example.mvvmretrofit.model.Meme

class JokesAdapter(private val  memesList: ArrayList<Meme>) : RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {
    class JokesViewHolder(val binding: CardMemeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val binding = CardMemeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokesViewHolder(binding)
    }

    override fun getItemCount(): Int = memesList.size

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        with(holder) {
            with(memesList[position]) {
                binding.tvName.text = this.name
            }
        }
    }
}