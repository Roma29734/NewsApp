package com.example.newsapp.ui.aps.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.data.model.localFav.FavEntity
import com.example.domain.model.FavModel
import com.example.newsapp.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding>
        (FragmentHomeBinding::inflate){

    private var contex: Context?= null

    private val viewModel: HomeViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contex = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val name = viewModel.getName()

            if(!viewModel.checkSize()) {
                mainNavController.navigate(R.id.action_navFragment_to_choosingCategoryFragment)
            } else {
                binding.viewPager.adapter = HomeViewPagerAdapter(contex as FragmentActivity)
                setingsTab(name)
            }

        }
    }

    private fun setingsTab(name: List<FavModel>) {
        view?.let {
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
                when(pos) {
                    0 -> {
                        tab.text = name[0].nameCat
                    }
                    1 -> {
                        tab.text = name[1].nameCat
                    }
                    2 -> {
                        tab.text = name[2].nameCat
                    }
                }
            }.attach()
        }
    }

}