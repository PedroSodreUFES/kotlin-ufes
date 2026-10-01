package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityPaginaPrincipalBinding

class PaginaPrincipal : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    private lateinit var binding: ActivityPaginaPrincipalBinding
    private lateinit var sp: SharedPreferences
    private var selectedAnimal = "cat"
    private lateinit var catSentences: MutableList<String>
    private lateinit var dogSentences: MutableList<String>
    private lateinit var fishSentences: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getSharedPreferences(
            "CHAVE",
            Context.MODE_PRIVATE,
        )
        val userName = sp.getString("NOME", null)
        binding.welcomingText.text = "Olá, ${userName}"

        val animalLastSelected = sp.getString("ANIMAL", null)
        if (animalLastSelected == "cat") {
            selectedAnimal = "cat"
            binding.catImage.setColorFilter(
                ContextCompat.getColor(this, R.color.yellow)
            )
        } else if (animalLastSelected == "dog") {
            selectedAnimal = "dog"
            binding.dogImage.setColorFilter(
                ContextCompat.getColor(this, R.color.yellow)
            )
        } else if (animalLastSelected == "fish") {
            selectedAnimal = "fish"
            binding.fishImage.setColorFilter(
                ContextCompat.getColor(this, R.color.yellow)
            )
        }
        else {
            selectedAnimal = "cat"
            binding.catImage.setColorFilter(
                ContextCompat.getColor(this, R.color.yellow)
            )
        }

        binding.randomSentence.setOnLongClickListener(this)
        binding.catImage.setOnClickListener(this)
        binding.dogImage.setOnClickListener(this)
        binding.fishImage.setOnClickListener(this)
        binding.generateSentenceButton.setOnClickListener(this)
        binding.returnButton.setOnClickListener(this)
        binding.randomSentence.text = "Clique no botão para gerar uma frase!"
        binding.returnButton.setColorFilter(
            ContextCompat.getColor(this, R.color.blue)
        )
        this.catSentences = resources.getStringArray(R.array.cat_sentences).toMutableList()
        this.dogSentences = resources.getStringArray(R.array.dog_sentences).toMutableList()
        this.fishSentences = resources.getStringArray(R.array.fish_sentences).toMutableList()
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
            binding.fishImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black)
            )
            sp.edit().putString("ANIMAL", "cat").apply()
        }
        else if(view.id == R.id.dogImage) {
            selectedAnimal = "dog"
            binding.dogImage.setColorFilter(
                ContextCompat.getColor(this, R.color.yellow)
            )
            binding.catImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black)
            )
            binding.fishImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black)
            )
            sp.edit().putString("ANIMAL", "dog").apply()
        }
        else if(view.id == R.id.fishImage) {
            selectedAnimal = "fish"
            binding.fishImage.setColorFilter(
                ContextCompat.getColor(this, R.color.yellow)
            )
            binding.catImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black)
            )
            binding.dogImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black)
            )
            sp.edit().putString("ANIMAL", "fish").apply()
        }
        else if(view.id == R.id.generateSentenceButton) {
            if (selectedAnimal == "cat") {
                if(catSentences.isEmpty()) {
                    binding.randomSentence.text = "Não há mais frases de gatos!"
                } else {
                    binding.randomSentence.text = catSentences.random()
                }
            } else if (selectedAnimal == "dog") {
                if(dogSentences.isEmpty()) {
                    binding.randomSentence.text = "Não há mais frases de cachorros!"
                } else {
                    binding.randomSentence.text = dogSentences.random()
                }
            } else if (selectedAnimal == "fish") {
                if(fishSentences.isEmpty()) {
                    binding.randomSentence.text = "Não há mais frases de peixes!"
                } else {
                    binding.randomSentence.text = fishSentences.random()
                }
            }
        }
        else if (view.id == R.id.returnButton) {
            sp.edit().remove("NOME").apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onLongClick(view: View): Boolean {
        if(view.id == R.id.randomSentence &&
            binding.randomSentence.text.toString() != "Clique no botão para gerar uma frase!" &&
            !binding.randomSentence.text.startsWith("Não há mais frases de")
            ) {
            if (selectedAnimal == "fish") {
                fishSentences.remove(binding.randomSentence.text.toString())
            }
            else if(selectedAnimal == "dog") {
                dogSentences.remove(binding.randomSentence.text.toString())
            }
            else if(selectedAnimal == "cat") {
                catSentences.remove(binding.randomSentence.text.toString())
            }
            Toast.makeText(
                applicationContext,
                "Frase removida!",
                Toast.LENGTH_SHORT
            ).show()
            binding.randomSentence.text = "Clique no botão para gerar uma frase!"
        }
        return true
    }
}