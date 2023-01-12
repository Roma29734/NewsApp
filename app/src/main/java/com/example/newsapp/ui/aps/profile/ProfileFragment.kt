package com.example.newsapp.ui.aps.profile

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentProfileBinding
import com.example.newsapp.ui.MainActivity
import com.example.newsapp.utils.ThemeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.coroutines.launch
import kotlin.math.log

@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding>
        (FragmentProfileBinding::inflate) {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textEmail.text = viewModel.user!!.email
        binding.textName.text = viewModel.user!!.displayName

        binding.matButtonExitProfile.setOnClickListener {
            dialogExit()
        }
        loadTheme()

        binding.ragioGroop.setOnCheckedChangeListener { radioGroup, i ->
            saveTheme()
            (requireActivity() as MainActivity).setTheme()
        }
    }

    fun loadTheme() {
        val loadTheme = (requireActivity() as MainActivity).loadData()
        val saveTheme = (requireActivity() as MainActivity)
        val group = binding.ragioGroop
        if(loadTheme == null) {
            saveTheme.saveDate(ThemeState.SYSTEM)
            group.rBSystem.isChecked = true
        } else {
            when(loadTheme) {
                "SYSTEM" -> {
                    group.rBSystem.isChecked = true
                }
                "DARK" -> {
                    group.rBDark.isChecked = true
                }
                "WHITE" -> {
                    group.rBWhile.isChecked = true
                }
            }
        }
    }

    fun saveTheme() {
        val saveTheme = (requireActivity() as MainActivity)

        val id = binding.ragioGroop.checkedRadioButtonId

        when(id) {
            R.id.rBDark -> {
                saveTheme.saveDate(ThemeState.DARK)
            }
            R.id.rBSystem -> {
                saveTheme.saveDate(ThemeState.SYSTEM)
            }
            R.id.rBWhile -> {
                saveTheme.saveDate(ThemeState.WHITE)
            }
        }
    }


    private fun dialogExit() {
        val builder = AlertDialog.Builder(context)
        builder.setPositiveButton("Yes") { _, _ ->
            lifecycleScope.launch {
                viewModel.exit()
            }
            Toast.makeText(context, "You success exit profile", Toast.LENGTH_SHORT).show()
            mainNavController.navigate(R.id.action_navFragment_to_loginFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Exit?")
        builder.setMessage("Are you sure you want to leave?")
        builder.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("destroyView","profileFragmentDestroy")
        saveTheme()
    }
}