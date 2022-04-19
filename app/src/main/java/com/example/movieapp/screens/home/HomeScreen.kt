package com.example.movieapp.screens.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.viewmodels.FavoritesViewModel
import com.example.testapp.models.Movie
import com.example.testapp.models.getMovies
import com.example.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    viewModel: FavoritesViewModel
) {
    var showMenu by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Movies") },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                    }

                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = { navController.navigate(MovieScreens.FavoritesScreen.name) }) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "Favorites",
                                    modifier = Modifier.padding(4.dp)
                                )
                                Text(
                                    text = "Favorites",
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .width(100.dp)
                                )
                            }

                        }
                    }
                }
            )
        }
    ) {
        MainContent(navController = navController, isFavorite = { movie ->
            viewModel.checkFavoriteStatus(movie)
        }) { movie ->
            if (viewModel.checkFavoriteStatus(movie)) {
                viewModel.removeMovie(movie)
            } else {
                viewModel.addMovie(movie)
            }
        }
    }
}

@Composable
fun MainContent(navController: NavController,
                movieList: List<Movie> = getMovies(),
                isFavorite: (Movie) -> Boolean,
                onFavorite: (Movie) -> Unit = {}){
    LazyColumn {
        items(items = movieList) { movie ->
            MovieRow(movie = movie,
                    favorite = isFavorite(movie),
                    onFavoriteClick = onFavorite,
                    showIcon = true,
                    onItemClick =  { movieId ->
                navController.navigate(route = MovieScreens.DetailScreen.name + "/$movieId")
            })
        }
    }
}