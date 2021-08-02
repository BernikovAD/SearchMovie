package com.example.searchmovie.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.searchmovie.databinding.FragmentMovieBinding
import com.example.searchmovie.viewmodel.AppState
import com.example.searchmovie.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar


class FragmentMovie : Fragment() {
    companion object {
        fun newInstance() = FragmentMovie()
    }
    lateinit var viewModel: MainViewModel
    private var _binding: FragmentMovieBinding? = null
    private val binding: FragmentMovieBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getMovie()
    }

    private fun renderData(appState: AppState) {
        when(appState){
            is AppState.Error -> TODO() //show errors
            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.mainView,"Success",Snackbar.LENGTH_LONG).show()
                setData(appState)
            }
            AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
        }
    }

    private fun setData(appState: AppState.Success) {
        binding.tvNameMovie.text = appState.dataMovie.nameMovie
        binding.tvDesription.text = appState.dataMovie.description
        binding.tvRating.text = appState.dataMovie.rating.toString()
    }
}