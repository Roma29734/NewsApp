package com.example.newsapp.ui.aps.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate){


    private var contex: Context?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contex = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = HomeViewPagerAdapter(contex as FragmentActivity)

        TabLayoutMediator(binding.tabLayout, view.viewPager) {
                tab, pos ->
            when(pos) {
                0 -> {
                    tab.text = "Business"
                }
                1 -> {
                    tab.text = "Technology"
                }
                2 -> {
                    tab.text = "Sports"
                }
            }
        }.attach()
    }
}