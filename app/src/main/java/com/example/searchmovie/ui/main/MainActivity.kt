package com.example.searchmovie.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.searchmovie.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container_navigation, MainFragment.newInstance()).commit()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container_movie,FragmentMovie.newInstance()).commit()
        }
    }
}