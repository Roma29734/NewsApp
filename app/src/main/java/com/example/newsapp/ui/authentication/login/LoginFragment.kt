package com.example.newsapp.ui.authentication.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.data.firebase.Resours
import com.example.newsapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment :
    BaseFragment<FragmentLoginBinding>
        (FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matButtonGo.setOnClickListener {
            viewModel.singIn(binding.tiEmail.text.toString(), binding.tiPassword.text.toString())
            viewModel.state.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is Resours.Failure -> {
                        Toast.makeText(
                            context,
                            "Exception ${state.exception}",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.progressBar.visibility = View.INVISIBLE
                    }
                    is Resours.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resours.Success -> {
                        Toast.makeText(context, "Complete", Toast.LENGTH_SHORT).show()
                        binding.progressBar.visibility = View.INVISIBLE
                        mainNavController
                            .navigate(R.id.action_loginFragment_to_navFragment)
                    }
                }
            }
        }

        binding.textGotoRegistr.setOnClickListener {
            mainNavController
                .navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }
}