package com.example.catalogofilmes.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmeDao {

    @Insert
    suspend fun inserir(filme: Filme)

    @Query("SELECT * FROM filmes")
    fun listarFilmes(): Flow<List<Filme>>
}