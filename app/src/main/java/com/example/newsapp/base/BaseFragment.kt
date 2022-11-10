package com.example.newsapp.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.newsapp.R
import com.example.newsapp.utils.NetworkState
import com.google.android.material.snackbar.Snackbar
import java.util.zip.Inflater


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<B : ViewBinding>(private val inflate: Inflate<B>) :
    Fragment(){
    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)
    protected val network by lazy { context?.let { NetworkState(it) } }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = inflate.invoke(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun showSnackBar(view: View) {
        Snackbar.make(view, R.string.no_internet, Snackbar.LENGTH_SHORT)
            .setTextColor(Color.BLACK)
            .setBackgroundTint(Color.WHITE)
            .show()
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        _viewBinding = null
//    }
}
