package com.example.newsapp.ui.aps.home.topHeadlines

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentTopHeadlinesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadlinesFragment() : BaseFragment<FragmentTopHeadlinesBinding,TopHeadlinesViewModel >(FragmentTopHeadlinesBinding::inflate) {
    override val viewModel: TopHeadlinesViewModel by viewModels()
    private val adapter = TopHeadlinesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerMain.adapter = adapter

        viewModel.news.observe(viewLifecycleOwner) {news ->
           if(news.isSuccessful) {
               news.body()?.let { adapter.setNews(it.articles) }
               Log.d("topFragment"," все гуд${news.message()}")
           } else {
               Log.d("topFragment"," все негуд${news.errorBody()}")
           }
        }
        binding.include.textWelcome.text = "TopHead News"
    }
}