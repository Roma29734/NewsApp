package com.example.newsapp.ui.aps.home.business

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentBusinessBinding
import com.example.newsapp.ui.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BusinessFragment: BaseFragment<FragmentBusinessBinding>(FragmentBusinessBinding::inflate) {
    private val viewModel: BusinessViewModel by viewModels()
    private val adapter = NewsAdapter()

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

    }
}