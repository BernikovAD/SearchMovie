package com.example.searchmovie.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.searchmovie.R
import com.example.searchmovie.databinding.MainFragmentBinding
import com.example.searchmovie.viewmodel.MainViewModel

class MainFragment : Fragment() {
    val _binding: MainFragmentBinding? = null
    var binding: MainFragmentBinding
        get() :MainFragmentBinding {
            return _binding!!
        }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

}