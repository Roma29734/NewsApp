package com.example.newsapp.ui.authentication.greetings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentGreetingsBinding
import com.example.newsapp.domain.NewsUserCase
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class GreetingsFragment : BaseFragment<FragmentGreetingsBinding>(FragmentGreetingsBinding::inflate) {

    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.matButtonGo.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_greetingsFragment_to_loginFragment)
        }
    }

    private fun checkRegistr() {

        if (firebaseAuth.currentUser != null) {
            view?.let {
                Navigation.findNavController(it).navigate(R.id.action_greetingsFragment_to_navFragment)
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