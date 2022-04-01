package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.testapp.models.Movie
import com.example.testapp.models.getMovies



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}


/*@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieRow(movieName: String, movieDirector: String, movieYear: String, moviePlot: String, movieGenres: String, movieRating: String){

    var openDescription by remember {
        mutableStateOf(false)
    }

    Row {
        Card(modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                openDescription = !openDescription
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
                    Text(text = movieName,
                        style = MaterialTheme.typography.h6)
                    Text(text = "Director: $movieDirector",
                        style = MaterialTheme.typography.caption)
                    Text(text = "Released: $movieYear",
                        style = MaterialTheme.typography.caption)
                    if (!openDescription)
                        Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "More info")
                    else
                        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Less info")

                    AnimatedVisibility(visible = openDescription,
                    enter = slideInVertically()) {
                        Column {
                            Divider(color = Color.LightGray, thickness = 1.dp)
                            Text(
                                text = "Plot: $moviePlot",
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier.padding(2.dp)
                            )
                            Text(
                                text = "Genre: $movieGenres",
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier.padding(2.dp)
                            )
                            Text(
                                text = "Rating: $movieRating",
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