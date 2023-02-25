package com.example.newsapp.ui.aps.home.first

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentFirstBinding
import com.example.newsapp.ui.adapter.NewsPagingAdapter
import com.example.newsapp.ui.aps.NavFragmentDirections
import com.example.newsapp.utils.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment :
    BaseFragment<FragmentFirstBinding>
        (FragmentFirstBinding::inflate) {

    private val viewModel: FirstViewModel by viewModels()
    private val adapter = NewsPagingAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        настройка адапрера
        adapter.callBackPress = {
            val action = NavFragmentDirections.actionNavFragmentToDetailFragment(it)
            mainNavController.navigate(action)
        }

        binding.recyclerMain.adapter = adapter

        viewModel.getNews()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.news.collectLatest { uiState ->
                    when (uiState.loadState) {
                        LoadState.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        LoadState.ERROR -> {
                            Toast.makeText(context, "ошибочка вышла", Toast.LENGTH_SHORT).show()
                            binding.progressBar.visibility = View.INVISIBLE
                        }
                        LoadState.SUCCESS -> {
                            uiState.successState?.let { adapter.submitData(it) }
                            binding.progressBar.visibility = View.INVISIBLE
                        }
                    }
                }
            }
        }
    }
}