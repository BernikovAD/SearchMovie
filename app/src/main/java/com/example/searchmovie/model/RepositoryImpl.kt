package com.example.searchmovie.model

class RepositoryImpl : Repository{
    override fun getMovieFromServer(): MovieItem {
        return MovieItem()
    }

    override fun getMovieFromLocal(): MovieItem {
        return MovieItem()
    }
}