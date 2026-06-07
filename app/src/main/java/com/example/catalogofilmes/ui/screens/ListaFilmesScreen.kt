package com.example.catalogofilmes.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListaFilmesScreen(
    aoAdicionar: () -> Unit
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = aoAdicionar
            ) {
                Text("+")
            }
        }
    ) { padding ->

        Text(
            text = "Lista de Filmes",
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        )
    }
}