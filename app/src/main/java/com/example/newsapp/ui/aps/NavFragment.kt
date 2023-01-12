package com.example.newsapp.ui.aps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentNavBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NavFragment :
    BaseFragment<FragmentNavBinding>
        (FragmentNavBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navView: BottomNavigationView = binding.bottomNavigationView
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_fragments) as NavHostFragment
        val navController = navHostFragment.findNavController()

        navView.setupWithNavController(navController)
    }
}