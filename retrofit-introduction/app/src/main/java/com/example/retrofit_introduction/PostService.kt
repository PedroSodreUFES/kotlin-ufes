package com.example.retrofit_introduction

import retrofit2.Call
import retrofit2.http.GET

class PostService {
    @GET("posts")
    fun getAllBlogPosts(): Call<List<PostEntity>>
}