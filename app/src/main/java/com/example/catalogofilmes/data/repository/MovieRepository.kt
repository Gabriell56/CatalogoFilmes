package com.example.catalogofilmes.data.repository

import com.example.catalogofilmes.data.local.MovieDao
import com.example.catalogofilmes.data.local.MovieEntity
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    suspend fun insertMovie(movie: MovieEntity) = movieDao.insertMovie(movie)

    suspend fun deleteMovie(id: Int) = movieDao.deleteMovie(id)
}