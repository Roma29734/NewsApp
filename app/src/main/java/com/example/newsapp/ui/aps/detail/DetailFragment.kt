package com.example.newsapp.ui.aps.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentDetailBinding
import com.example.newsapp.utils.NetworkState
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val args by navArgs<DetailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        network?.observe(viewLifecycleOwner) { state ->
            if(state) {
                Log.d("detailFragment","есть интернет")
                binding.webView.webViewClient = WebViewClient()
                binding.progressBar.visibility = View.VISIBLE
                binding.webView.loadUrl(args.newsState.url)
                binding.progressBar.visibility = View.INVISIBLE
                binding.webView.settings.setSupportZoom(true)
            } else {
                Log.d("detailFragment","нет интеренат")
                showSnackBar(view)
            }
        }

        binding.include3.imageButtonBack.setOnClickListener {
            nav.popBackStack()
        }
    }
}