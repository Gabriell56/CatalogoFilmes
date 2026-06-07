package com.example.catalogofilmes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CadastroFilmeScreen(
    aoVoltar: () -> Unit
) {

    var titulo by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = genero,
            onValueChange = { genero = it },
            label = { Text("Gênero") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = aoVoltar,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Salvar")
        }
    }
}