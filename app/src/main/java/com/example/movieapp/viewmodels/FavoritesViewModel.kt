package com.example.movieapp.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.testapp.models.Movie

class FavoritesViewModel : ViewModel() {

    private val _favoriteMovies = mutableStateListOf<Movie>()
    val favoriteMovies: List<Movie>
        get() = _favoriteMovies



    fun addMovie(movie: Movie){
        _favoriteMovies.add(movie)
    }

    fun removeMovie(movie: Movie){
        _favoriteMovies.remove(movie)
    }

    fun getAllMovies(movie: Movie) : List<Movie>{
        return _favoriteMovies
    }

    fun checkFavoriteStatus(movie: Movie) : Boolean {
        return _favoriteMovies.contains(movie)
    }
}