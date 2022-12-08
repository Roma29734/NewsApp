package com.example.newsapp.ui.aps.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.ui.aps.home.first.FirstFragment
import com.example.newsapp.ui.aps.home.second.SecondFragment
import com.example.newsapp.ui.aps.home.third.ThirdFragment

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> {
                ThirdFragment()
            }
        }
    }
}