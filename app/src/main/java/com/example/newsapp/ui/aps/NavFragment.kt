package com.example.newsapp.ui.aps

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNavBinding
import com.example.newsapp.ui.MainActivity
import com.example.newsapp.ui.aps.home.HomeFragment
import com.example.newsapp.ui.aps.home.business.BusinessFragment
import com.example.newsapp.ui.aps.profile.ProfileFragment
import com.example.newsapp.ui.aps.search.SearchFragment
import com.example.newsapp.ui.authentication.login.LoginFragment
import com.example.newsapp.ui.authentication.login.LoginFragmentDirections
import com.example.newsapp.ui.authentication.registr.RegistrationFragmentDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NavFragment : Fragment() {

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
        val homeFragment = HomeFragment()
        val profileFragmnet = ProfileFragment()
        val searchFragment = SearchFragment()


        if (savedInstanceState == null) {
            setCurrentFragment(HomeFragment())
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    setCurrentFragment(homeFragment)
//                    true
                }
                R.id.search -> {
                    Log.d("navFragment", "зашель в сеарч")
                    setCurrentFragment(searchFragment)
//                    true
                }
                R.id.profile -> {
                    setCurrentFragment(profileFragmnet)
//                    true
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
//        parentFragmentManager.beginTransaction().apply {
//            replace(R.id.fragmentView, fragment)
//            commit()
//        }

        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentView,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onStart() {
        super.onStart()
    }
}