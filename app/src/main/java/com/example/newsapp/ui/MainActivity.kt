package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.newsapp.R
import com.example.newsapp.utils.ThemeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_profile.view.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_NewsApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun saveDate(state: ThemeState) {
        val sheared = getSharedPreferences("stateTheme", MODE_PRIVATE)

        sheared.edit().apply{
            putString("STATE_KEY", state.toString())
        }.apply()
    }

    fun loadData(): String? {
        val sheared = getSharedPreferences("stateTheme", MODE_PRIVATE)

        return sheared.getString("STATE_KEY", null)
    }

    fun setTheme () {
        when(loadData()) {
            null -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
            }
            "SYSTEM" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
            }
            "DARK" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
            "WHITE" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        setTheme()
    }
}
