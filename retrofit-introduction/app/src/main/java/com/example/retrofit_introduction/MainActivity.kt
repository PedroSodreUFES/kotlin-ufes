package com.example.retrofit_introduction

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_introduction.databinding.ActivityMainBinding
import retrofit2.Call

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val postService = ClientRetrofit.createPostService()
        val listCall: Call<List<PostEntity>> = postService.getAllBlogPosts()
    }

    override fun onClick(view: View) {
        if(view.id == R.id.main) {

        }
    }

    private fun setObserver() {

    }
}