package com.example.movieapp.screens.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.widgets.MovieRow
import com.example.testapp.models.Movie
import com.example.testapp.models.getMovies

@Preview(showBackground = true)
@Composable
fun FavoritesScreen (navController: NavController = rememberNavController()){


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
        MainContent()
    }
}


@Composable
fun MainContent(movieList: List<Movie> = getMovies()){
    Column {
        MovieRow(movieList[3])
        MovieRow(movieList[7])
    }
}