package com.example.catalogofilmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catalogofilmes.data.local.MovieDatabase
import com.example.catalogofilmes.data.repository.MovieRepository
import com.example.catalogofilmes.ui.navigation.NavGraph
import com.example.catalogofilmes.viewmodel.MovieViewModel
import com.example.catalogofilmes.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = MovieDatabase.getDatabase(this)
        val repository = MovieRepository(database.movieDao())

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: MovieViewModel = viewModel(
                        factory = MovieViewModelFactory(repository)
                    )
                    NavGraph()
                }
            }
        }
    }
}