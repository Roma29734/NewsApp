package com.example.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.model.Article
import com.example.newsapp.databinding.CardNewsRowBinding

class NewsAdapter(): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var newsList = emptyList<Article>()

    class ViewHolder (val binding: CardNewsRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardNewsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val positionNews = newsList[position]
        holder.binding.textTitle.text = positionNews.title
        holder.binding.textSubTitle.text = positionNews.description
        Glide.with(holder.itemView.context)
            .load(positionNews.urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setNews(list: List<Article>) {
        newsList = list
        notifyDataSetChanged()
    }
}