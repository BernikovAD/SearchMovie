package com.example.searchmovie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchmovie.model.Repository
import com.example.searchmovie.model.RepositoryImpl

class MainViewModel(private val liveDataObserver: MutableLiveData<AppState> = MutableLiveData(),val repository : Repository = RepositoryImpl()) : ViewModel() {
    fun getLiveData( )= liveDataObserver

    fun getMovie() = getMovieFromLocalSource()

    fun getMovieFromLocalSource(){
        Thread{
            liveDataObserver.postValue(AppState.Loading)
            Thread.sleep(4000)
            liveDataObserver.postValue(AppState.Success(repository.getMovieFromLocal()))
        }.start()
    }
}
