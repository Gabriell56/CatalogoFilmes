package com.example.catalogofilmes.data

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var instancia: FilmeDatabase? = null

    fun getDatabase(context: Context): FilmeDatabase {

        if (instancia == null) {

            instancia = Room.databaseBuilder(
                context,
                FilmeDatabase::class.java,
                "filmes.db"
            ).build()
        }

        return instancia!!
    }
}