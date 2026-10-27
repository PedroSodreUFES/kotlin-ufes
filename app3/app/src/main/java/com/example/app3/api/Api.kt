package com.example.app3.api

import com.example.app3.models.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("ws/{cep}/json/")
    fun buscarCep(
        @Path("cep") cep: String
    ): Call<Endereco>
}