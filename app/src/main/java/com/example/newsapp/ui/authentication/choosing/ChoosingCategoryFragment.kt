package com.example.newsapp.ui.authentication.choosing

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
import com.example.newsapp.databinding.FragmentChoosingCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChoosingCategoryFragment : BaseFragment<FragmentChoosingCategoryBinding>(FragmentChoosingCategoryBinding::inflate) {

    private val viewModel: ChoosingCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chipBusiness.setOnClickListener {
            if (binding.chipBusiness.isChecked) {
                viewModel.addCat("business")
                Toast.makeText(context, "Business selected", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteCat("business")
                Toast.makeText(context, "Business deselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.chipEntertainment.setOnClickListener {
            if (binding.chipEntertainment.isChecked) {
                viewModel.addCat("entertainment")
                Toast.makeText(context, "Entertainment selected", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteCat("entertainment")
                Toast.makeText(context, "Entertainment deselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.chipGeneral.setOnClickListener {
            if (binding.chipGeneral.isChecked) {
                viewModel.addCat("general")
                Toast.makeText(context, "General selected", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteCat("general")
                Toast.makeText(context, "General deselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.chipHealth.setOnClickListener {
            if (binding.chipHealth.isChecked) {
                viewModel.addCat("health")
                Toast.makeText(context, "Health selected", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteCat("health")
                Toast.makeText(context, "Health deselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.chipScience.setOnClickListener {
            if (binding.chipScience.isChecked) {
                viewModel.addCat("science")
                Toast.makeText(context, "Science selected", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteCat("science")
                Toast.makeText(context, "Science deselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.chipSports.setOnClickListener {
            if (binding.chipSports.isChecked) {
                viewModel.addCat("sports")
                Toast.makeText(context, "Sports selected", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteCat("sports")
                Toast.makeText(context, "Sports deselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.chipTechnology.setOnClickListener {
            if (binding.chipTechnology.isChecked) {
                viewModel.addCat("technology")
                Toast.makeText(context, "Technology selected", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteCat("technology")
                Toast.makeText(context, "Technology deselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.matButtonGo.setOnClickListener {
            if(viewModel.addedList.size == 3) {
                viewModel.addToDataBase { callBack() }
            } else if(viewModel.addedList.size < 2) {
                Toast.makeText(context, "need 3 categories", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "no more than 3 categories", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun callBack() {
        view.let { it?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_choosingCategoryFragment_to_navFragment) } }
    }
}