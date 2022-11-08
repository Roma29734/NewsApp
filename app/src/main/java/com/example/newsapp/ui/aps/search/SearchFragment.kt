package com.example.newsapp.ui.aps.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentSearchBinding
import com.example.newsapp.ui.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private val viewModel: SearchViewModel by viewModels()
    private val adapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerSearch.adapter = adapter

        binding.include.SearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0 != null) {
                    if(p0.isNotEmpty()) {
                        p0?.let { viewModel.searchNews(p0) }
                    }
                }
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0 != null) {
                    if(p0.isNotEmpty()) {
                        p0?.let { viewModel.searchNews(p0) }
                    }
                }
                return false
            }
        })

        network?.observe(viewLifecycleOwner) { state ->
            if(state) {
                viewModel.searchResult.observe(viewLifecycleOwner) {result ->

                    result?.body()?.let { adapter.setNews(it.articles) }

                }
            } else {
                showSnackBar(view)
            }
        }


    }
}