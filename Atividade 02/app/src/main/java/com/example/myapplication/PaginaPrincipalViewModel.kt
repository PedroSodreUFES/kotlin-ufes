package com.example.myapplication

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

class PaginaPrincipalViewModel(application: Application): AndroidViewModel(application) {
    private val sp = application.getSharedPreferences(
        "CHAVE",
        Context.MODE_PRIVATE
    )

    private val possibleAnimals = setOf("cat", "dog", "fish")
}