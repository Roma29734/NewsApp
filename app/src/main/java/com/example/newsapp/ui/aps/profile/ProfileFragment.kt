package com.example.newsapp.ui.aps.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textEmail.text = viewModel.user!!.email
        binding.textName.text = viewModel.user!!.displayName

        binding.matButtonExitProfile.setOnClickListener {
            viewModel.exit()
            Toast.makeText(context, "You success exit profile", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(view).navigate(R.id.action_navFragment_to_loginFragment)
        }
    }
}