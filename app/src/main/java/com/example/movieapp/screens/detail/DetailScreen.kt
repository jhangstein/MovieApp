package com.example.movieapp.screens.detail

import android.view.RoundedCorner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.movieapp.viewmodels.FavoritesViewModel
import com.example.movieapp.widgets.MovieRow
import com.example.testapp.models.Movie
import com.example.testapp.models.getMovies

@Composable
fun DetailScreen(navController: NavController = rememberNavController(),
                 movieID: String? = "tt0499549",
                 viewModel: FavoritesViewModel){

    val movie = filterMovie(movieID)

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Cyan, elevation = 3.dp){
                Row {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = movie.title)
                }

            }
        }
    ) {
        MainContent(movie, favorite = {movie -> viewModel.checkFavoriteStatus(movie)}) { movie ->
            if (viewModel.checkFavoriteStatus(movie)) {
                viewModel.removeMovie(movie)
            } else {
                viewModel.addMovie(movie)
            }
        }
    }
}

@Composable
fun MainContent(movie: Movie,
                favorite: (Movie) -> Boolean,
                onFavoriteClick: (Movie) -> Unit = {}){

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MovieRow(movie = movie,
                favorite = favorite(movie),
                onFavoriteClick = onFavoriteClick,
                showIcon = true)

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Movie Images",
            style = MaterialTheme.typography.h5)

        LazyRow (modifier = Modifier.height(250.dp)) {
            items(items = movie.images) { image ->
                AsyncImage(
                    model = image,
                    contentDescription = "movie image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(10.dp)
                        .clip(RoundedCornerShape(3)
                        )
                )
            }
        }
    }
}


fun filterMovie(movieID: String?): Movie {
    return getMovies().filter { movie -> movie.id == movieID }[0]   //if list contains multiple entries, only return first match
}
