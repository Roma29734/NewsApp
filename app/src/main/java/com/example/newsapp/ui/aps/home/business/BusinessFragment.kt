package com.example.newsapp.ui.aps.home.business

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentBusinessBinding
import com.example.newsapp.ui.adapter.NewsAdapter
import com.example.newsapp.utils.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BusinessFragment: BaseFragment<FragmentBusinessBinding>(FragmentBusinessBinding::inflate) {
    private val viewModel: BusinessViewModel by viewModels()
    private val adapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerMain.adapter = adapter

        network?.observe(viewLifecycleOwner){state ->
            if(state) {
                viewModel.getNews()
            } else {
                Log.d("topFragment"," нет интернета")
            }
        }

        viewModel.news.observe(viewLifecycleOwner) {news ->
            if(news.isSuccessful) {
                Log.d("topFragment","сделал запрос${news.message()}")
                news.body()?.let { adapter.setNews(it.articles) }
                Log.d("topFragment"," все гуд${news.message()}")
            } else {
                Log.d("topFragment"," все негуд${news.errorBody()}")
            }
        }


    }
}