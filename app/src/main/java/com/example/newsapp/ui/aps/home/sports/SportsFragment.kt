package com.example.newsapp.ui.aps.home.sports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentSportsBinding
import com.example.newsapp.ui.adapter.NewsAdapter
import com.example.newsapp.utils.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportsFragment(): BaseFragment<FragmentSportsBinding>(FragmentSportsBinding::inflate) {
    private val viewModel: SportsViewModel by viewModels()
    private val adapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerMain.adapter = adapter

        network?.observe(viewLifecycleOwner) {state ->
            if (state) {
                viewModel.news.observe(viewLifecycleOwner) {news->
                    if(news.isSuccessful) {
                        news.body()?.let { adapter.setNews(it.articles) }
                    }
                }
            } else {
                showSnackBar(view)
            }
        }
    }
}