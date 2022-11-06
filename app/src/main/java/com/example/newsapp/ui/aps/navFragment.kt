package com.example.newsapp.ui.aps

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNavBinding
import com.example.newsapp.ui.aps.home.topHeadlines.TopHeadlinesFragment
import com.example.newsapp.ui.aps.profile.ProfileFragment
import com.example.newsapp.ui.aps.search.SearchFragment


class navFragment : Fragment() {

    private var _binding: FragmentNavBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topheadlinesFragment = TopHeadlinesFragment()
        val profileFragmnet = ProfileFragment()
        val searchFragment = SearchFragment()

        setCurrentFragment(topheadlinesFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> setCurrentFragment(topheadlinesFragment)
                R.id.search -> setCurrentFragment(searchFragment)
                R.id.profile -> setCurrentFragment(profileFragmnet)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentView, fragment)
            commit()
        }
    }

}