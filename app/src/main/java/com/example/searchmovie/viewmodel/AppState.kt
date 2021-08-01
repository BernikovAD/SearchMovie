package com.example.searchmovie.viewmodel

import com.example.searchmovie.model.Movie

sealed class AppState {

    data class Success(val dataMovie: Movie):AppState()
    data class Error( val error:Throwable):AppState()
    object Loading: AppState()
}