package com.example.movieapp.screens.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.viewmodels.FavoritesViewModel
import com.example.movieapp.widgets.MovieRow
import com.example.testapp.models.Movie
import com.example.testapp.models.getMovies

@Composable
fun FavoritesScreen (navController: NavController = rememberNavController(), viewModel: FavoritesViewModel){


    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 3.dp){
                Row {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = "My Favorite Movies")
                }

            }
        }
    ) {
        MainContent(favorites = viewModel.favoriteMovies, navController = navController)
    }
}


@Composable
fun MainContent(favorites: List<Movie>, navController: NavController){

    LazyColumn {
        items(favorites) { movie ->
            MovieRow(movie = movie, showIcon = false, favorite = false, onItemClick = {
                navController.navigate(route = MovieScreens.DetailScreen.name + "/${movie.id}")
            }) {

            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
        }
    }
}