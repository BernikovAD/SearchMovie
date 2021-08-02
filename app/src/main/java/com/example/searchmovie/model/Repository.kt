package com.example.searchmovie.model

    interface Repository {
        fun getMovieFromServer(): MovieItem
        fun getMovieFromLocal(): MovieItem
    }