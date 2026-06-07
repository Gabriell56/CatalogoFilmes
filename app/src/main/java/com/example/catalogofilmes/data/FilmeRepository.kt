package com.example.catalogofilmes.data

class FilmeRepository(
    private val filmeDao: FilmeDao
) {

    fun listarFilmes() = filmeDao.listarFilmes()

    suspend fun inserir(filme: Filme) {
        filmeDao.inserir(filme)
    }
}