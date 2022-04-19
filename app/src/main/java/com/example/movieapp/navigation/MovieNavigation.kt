package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.detail.DetailScreen
import com.example.movieapp.screens.favorites.FavoritesScreen
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.viewmodels.FavoritesViewModel

@Composable
fun MovieNavigation(){

    val favoritesViewModel: FavoritesViewModel = viewModel()
    favoritesViewModel.favoriteMovies

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name) { HomeScreen(navController = navController, viewModel = favoritesViewModel) }

        composable(MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument("movie") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            DetailScreen(navController = navController, movieID = backStackEntry.arguments?.getString("movie"), viewModel = favoritesViewModel) //if not null, get String from movie
        }

        composable(MovieScreens.FavoritesScreen.name) { FavoritesScreen(navController = navController, viewModel = favoritesViewModel)}
    }
}