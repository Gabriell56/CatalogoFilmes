package com.example.catalogofilmes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catalogofilmes.ui.screens.CadastroFilmeScreen
import com.example.catalogofilmes.ui.screens.ListaFilmesScreen

object Rotas {
    const val LISTA = "lista"
    const val CADASTRO = "cadastro"
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rotas.LISTA
    ) {

        composable(Rotas.LISTA) {
            ListaFilmesScreen(
                aoAdicionar = {
                    navController.navigate(Rotas.CADASTRO)
                }
            )
        }

        composable(Rotas.CADASTRO) {
            CadastroFilmeScreen(
                aoVoltar = {
                    navController.popBackStack()
                }
            )
        }
    }
}