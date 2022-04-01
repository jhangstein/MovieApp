package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testapp.models.Movie
import com.example.testapp.models.getMovies

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieRow(movie: Movie = getMovies()[0],
            onItemClick: (String) -> Unit = {}) {

    var openDescription by remember {
        mutableStateOf(false)
    }

    Row {
        Card(modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
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
                    shape = RectangleShape
                ){
                    AsyncImage(model = movie.images[0],
                        contentDescription = "movie poster",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clip(CircleShape))
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
}