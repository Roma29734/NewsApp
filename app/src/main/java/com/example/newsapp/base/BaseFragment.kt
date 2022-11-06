package com.example.newsapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import java.util.zip.Inflater


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
abstract class BaseFragment<B : ViewBinding>(private val inflate: Inflate<B>) :
    Fragment(){
    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)

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

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}
