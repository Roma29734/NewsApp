package com.example.newsapp.ui.aps.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.ui.aps.home.business.BusinessFragment
import com.example.newsapp.ui.aps.home.sports.SportsFragment
import com.example.newsapp.ui.aps.home.technology.TechnologyFragment

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> BusinessFragment()
            1 -> TechnologyFragment()
            else -> {
                SportsFragment()
            }
        }
    }
}