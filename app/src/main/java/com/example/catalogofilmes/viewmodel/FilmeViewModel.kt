package com.example.catalogofilmes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogofilmes.data.Filme
import com.example.catalogofilmes.data.FilmeRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FilmeViewModel(
    private val repository: FilmeRepository
) : ViewModel() {

    val filmes = repository
        .listarFilmes()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    fun adicionarFilme(
        titulo: String,
        genero: String,
        descricao: String
    ) {
        viewModelScope.launch {
            repository.inserir(
                Filme(
                    titulo = titulo,
                    genero = genero,
                    descricao = descricao
                )
            )
        }
    }
}