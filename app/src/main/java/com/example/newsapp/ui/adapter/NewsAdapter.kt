package com.example.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.detModel.DetailModel
import com.example.newsapp.databinding.CardNewsRowBinding
import com.example.newsapp.databinding.NewsCardRowBinding
import com.example.newsapp.ui.aps.NavFragment
import com.example.newsapp.ui.aps.NavFragmentDirections

class NewsAdapter(
    val navigation: NavController
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var newsList = emptyList<Article>()

    class ViewHolder (val binding: NewsCardRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NewsCardRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val positionNews = newsList[position]
        val at = positionNews.publishedAt
        val result = "${at[11]}${at[12]}${at[13]}${at[14]}${at[15]}"

        holder.binding.textTitle.text = positionNews.title
        holder.binding.textTime.text = result
        holder.binding.textSource.text = positionNews.source.name
//        holder.binding.textSubTitle.text = positionNews.description
//        Glide.with(holder.itemView.context)
//            .load(positionNews.urlToImage)
//            .placeholder(R.drawable.ic_launcher_background)
//            .into(holder.binding.imageView)


        holder.binding.cardNews.setOnClickListener {
            val model = DetailModel(positionNews.url)
            val action = NavFragmentDirections.actionNavFragmentToDetailFragment(model)
            navigation.navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setNews(list: List<Article>) {
        newsList = list
        notifyDataSetChanged()
    }
}