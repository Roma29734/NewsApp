package com.example.newsapp.ui.aps.profile

import android.app.AlertDialog
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
import com.example.newsapp.databinding.FragmentProfileBinding
import com.example.newsapp.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textEmail.text = viewModel.user!!.email
        binding.textName.text = viewModel.user!!.displayName

        binding.matButtonExitProfile.setOnClickListener {
            dialogExit()
        }
    }

    fun dialogExit() {
        val builder = AlertDialog.Builder(context)
        builder.setPositiveButton("Yes") { _, _ ->
            lifecycleScope.launch {
                viewModel.exit()
            }
            Toast.makeText(context, "You success exit profile", Toast.LENGTH_SHORT).show()
            view?.let { Navigation.findNavController(it).navigate(R.id.action_navFragment_to_loginFragment) }
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Exit?")
        builder.setMessage("Are you sure you want to leave?")
        builder.create().show()
    }
}