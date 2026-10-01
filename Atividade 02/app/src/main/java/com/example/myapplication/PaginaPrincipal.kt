package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityPaginaPrincipalBinding

class PaginaPrincipal : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPaginaPrincipalBinding
    private var selectedAnimal = "cat"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences(
            "CHAVE",
            Context.MODE_PRIVATE,
        )
        val userName = sp.getString("NOME", null)
        binding.welcomingText.text = "Olá, ${userName}"

        binding.catImage.setOnClickListener(this)
        binding.catImage.setColorFilter(
            ContextCompat.getColor(this, R.color.yellow)
        )
        binding.dogImage.setOnClickListener(this)
        binding.generateSentenceButton.setOnClickListener(this)
        binding.randomSentence.text = "Clique no botão para gerar uma frase!"
    }

    override fun onClick(view: View) {
        if(view.id == R.id.catImage) {
            selectedAnimal = "cat"
            binding.catImage.setColorFilter(
                ContextCompat.getColor(this, R.color.yellow)
            )
            binding.dogImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black)
            )
        }
        else if(view.id == R.id.dogImage) {
            selectedAnimal = "dog"
            binding.dogImage.setColorFilter(
                ContextCompat.getColor(this, R.color.yellow)
            )
            binding.catImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black)
            )
        } else if(view.id == R.id.generateSentenceButton) {
            if (selectedAnimal == "cat") {
                val sentences = resources.getStringArray(R.array.cat_sentences)
                binding.randomSentence.text = sentences.random()
            } else if (selectedAnimal == "dog") {
                val sentences = resources.getStringArray(R.array.dog_sentences)
                binding.randomSentence.text = sentences.random()
            }
        }
    }
}