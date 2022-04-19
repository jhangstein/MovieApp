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
fun HomeScreen(navController: NavController = rememberNavController(), viewModel: FavoritesViewModel){
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
        MainContent(navController = navController)
    }
    }

@Composable
fun MainContent(navController: NavController, movieList: List<Movie> = getMovies()){
    LazyColumn {
        items(items = movieList) { movie ->
            MovieRow(movie = movie) { movieId ->
                navController.navigate(route = MovieScreens.DetailScreen.name + "/$movieId")
            }
        }
    }
}




/*
@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    var showMenu by remember {
        mutableStateOf(false)
    }
    MovieAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Movies") },
                    actions = {
                        IconButton(onClick = { showMenu = !showMenu }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                        }

                        DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                            DropdownMenuItem(onClick = {


                            }) {
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
            MainContent()
        }
    }
}*/



/*@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieRow(movie: Movie = getMovies()[0],
            onItemClick: (String) -> Unit = {}){

    var openDescription by remember {
        mutableStateOf(false)
    }

    Row {
        Card(modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
                //openDescription = !openDescription
            }
            .heightIn(130.dp, 400.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = 6.dp
        ){
            Row(verticalAlignment = Alignment.CenterVertically){
                Surface(modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                    shape = RectangleShape,
                    elevation = 6.dp
                ){
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Here should be a profile pic")
                }
                Column {
                    Text(text = movie.title,
                        style = MaterialTheme.typography.h6)
                    Text(text = "Director: ${movie.director}",
                        style = MaterialTheme.typography.caption)
                    Text(text = "Released: ${movie.year}",
                        style = MaterialTheme.typography.caption)
                    if (!openDescription)
                        Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "More info")
                    else
                        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Less info")

                    AnimatedVisibility(visible = openDescription,
                        enter = slideInVertically()
                    ) {
                        Column {
                            Divider(color = Color.LightGray, thickness = 1.dp)
                            Text(
                                text = "Plot: ${movie.plot}",
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier.padding(2.dp)
                            )
                            Text(
                                text = "Genre: ${movie.genre}",
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier.padding(2.dp)
                            )
                            Text(
                                text = "Rating: ${movie.rating}",
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }
                }

            }
        }
    }
}*/
