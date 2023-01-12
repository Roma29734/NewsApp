package com.example.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.detModel.DetailModel
import com.example.domain.model.ArticleDomain
import com.example.newsapp.databinding.NewsCardRowBinding


class NewsAdapter(
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var newsList = emptyList<ArticleDomain>()

    class ViewHolder (val binding: NewsCardRowBinding) : RecyclerView.ViewHolder(binding.root)

    var callBackPress: ((detailModel: DetailModel) -> Unit)? = null

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

        holder.binding.cardNews.setOnClickListener {
            val model = DetailModel(positionNews.url)

            callBackPress?.let { it1 -> it1(model) }
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setNews(list: List<ArticleDomain>) {
        newsList = list
        notifyDataSetChanged()
    }
}