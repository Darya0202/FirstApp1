package com.example.firstapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemNewsBinding
import com.example.firstapp.models.NewsItem

class NewsAdapter(private val newsList: List<NewsItem>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.binding.newsTitle.text = news.title
        holder.binding.newsDescription.text = news.description
        Glide.with(holder.binding.root.context).load(news.imageUrl).into(holder.binding.newsImage)
        Glide.with(holder.itemView.context)
            .load(news.imageUrl)
            .placeholder(R.drawable.placeholder_image) // Загрузка-заглушка
            .error(R.drawable.error_image) // Ошибка-заглушка
            .into(holder.binding.newsImage)
    }

    override fun getItemCount(): Int = newsList.size
}