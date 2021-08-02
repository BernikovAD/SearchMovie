package com.example.searchmovie.viewmodel

import com.example.searchmovie.model.MovieItem

sealed class AppState {

    data class Success(val dataMovie: MovieItem):AppState()
    data class Error( val error:Throwable):AppState()
    object Loading: AppState()
}