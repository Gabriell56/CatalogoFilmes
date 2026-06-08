package com.example.catalogofilmes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogofilmes.data.local.MovieEntity
import com.example.catalogofilmes.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableStateFlow<List<MovieEntity>>(emptyList())
    val movies: StateFlow<List<MovieEntity>> = _movies.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            repository.getAllMovies().collect { movieList ->
                _movies.value = movieList
            }
        }
    }

    fun addMovie(titulo: String, genero: String, descricao: String) {
        viewModelScope.launch {
            val movie = MovieEntity(
                titulo = titulo,
                genero = genero,
                descricao = descricao
            )
            repository.insertMovie(movie)
        }
    }

    fun deleteMovie(id: Int) {
        viewModelScope.launch {
            repository.deleteMovie(id)
        }
    }
}