package com.example.newsapp.ui.aps.search

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentSearchBinding
import com.example.newsapp.ui.adapter.NewsPagingAdapter
import com.example.newsapp.ui.aps.NavFragmentDirections
import com.example.newsapp.utils.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding>
        (FragmentSearchBinding::inflate) {

    private val viewModel: SearchViewModel by viewModels()
    private val adapter = NewsPagingAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        настройка адапрера
        adapter.callBackPress = {
            val action = NavFragmentDirections.actionNavFragmentToDetailFragment(it)
            mainNavController.navigate(action)
        }

        binding.recyclerSearch.adapter = adapter

        binding.include.SearchView.requestFocus()

        binding.include.SearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0 != null) {
                    if (p0.isNotEmpty()) {
                        p0.let { viewModel.searchNews(p0) }
                    }
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0 != null) {
                    if (p0.isNotEmpty()) {
                        p0.let { viewModel.searchNews(p0) }
                    }
                }
                return false
            }
        })

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchResult.collectLatest { uiState ->
                    when (uiState.loadState) {
                        LoadState.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        LoadState.ERROR -> {
                            binding.progressBar.visibility = View.INVISIBLE
                            Toast.makeText(context, "произашла ошибка", Toast.LENGTH_SHORT).show()
                        }
                        LoadState.SUCCESS -> {
                            binding.progressBar.visibility = View.INVISIBLE
                            uiState.successState?.let { adapter.submitData(it) }
                        }
                    }
                }
            }
        }
    }
}