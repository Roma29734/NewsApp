package com.example.newsapp.ui.aps.home.topHeadlines

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentEverythingBinding


class TopHeadlinesFragment() : BaseFragment<FragmentEverythingBinding,TopHeadlinesViewModel >(FragmentEverythingBinding::inflate) {
    override val viewModel: TopHeadlinesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}