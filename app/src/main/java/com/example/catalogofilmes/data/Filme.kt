package com.example.catalogofilmes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "filmes")
data class Filme(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val genero: String,
    val descricao: String
) {


}