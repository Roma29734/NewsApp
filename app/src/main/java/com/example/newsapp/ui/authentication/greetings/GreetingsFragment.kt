package com.example.newsapp.ui.authentication.greetings

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentGreetingsBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GreetingsFragment :
    BaseFragment<FragmentGreetingsBinding>
        (FragmentGreetingsBinding::inflate) {

    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.matButtonGo.setOnClickListener {
            mainNavController.navigate(R.id.action_greetingsFragment_to_loginFragment)
        }
    }

    private fun checkRegistr() {

        if (firebaseAuth.currentUser != null) {
            view?.let {
                mainNavController.navigate(R.id.action_greetingsFragment_to_navFragment)
            }
        } else {
            Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        checkRegistr()
    }
}