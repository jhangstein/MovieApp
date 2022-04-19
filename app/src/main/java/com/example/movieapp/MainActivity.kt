package com.example.movieapp

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.navigation.MovieNavigation
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.viewmodels.FavoritesViewModel
import com.example.testapp.models.Movie
import com.example.testapp.models.getMovies



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "Process created")

        /*//Initialize ViewModel for favorites
        val favoritesViewModel: FavoritesViewModel by viewModels()
        favoritesViewModel.favoriteMovies*/

        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieApp{
                        MovieNavigation()
                    }
                }
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "Process started")
    }


    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "Process resumed")
    }


    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "Process stopped")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "Process destroyed :(")
    }

}














@Composable
fun MovieApp(content: @Composable () -> Unit){
    MovieAppTheme {
            content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTheme {
        MovieApp{
            MovieNavigation()
        }
    }
}