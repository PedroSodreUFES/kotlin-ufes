package com.example.retrofit_introduction

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ClientRetrofit {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun getClientInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if(!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun createPostService(): PostService {
            return getClientInstance().create(PostService::class.java)
        }
    }
}