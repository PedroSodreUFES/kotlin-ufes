package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.databinding.ActivityPaginaPrincipalBinding

class PaginaPrincipal : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    private lateinit var binding: ActivityPaginaPrincipalBinding
    private lateinit var sp: SharedPreferences
    private var selectedAnimal = "cat"
    private val sentenceLiveData = MutableLiveData<String>()
    private val possibleAnimals : Set<String> = setOf("cat", "dog", "fish")
    private lateinit var catSentences: MutableList<String>
    private lateinit var dogSentences: MutableList<String>
    private lateinit var fishSentences: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getSharedPreferences(
            "CHAVE",
            MODE_PRIVATE,
        )
        val userName = sp.getString("NOME", null)
        binding.welcomingText.text = "${getString(R.string.welcome_text)}, $userName"

        val lastSelectedAnimal = sp.getString("ANIMAL", null)
        if(!lastSelectedAnimal.isNullOrEmpty() && lastSelectedAnimal in possibleAnimals) {
            selectedAnimal = lastSelectedAnimal
            when (selectedAnimal) {
                "cat" -> {
                    binding.catImage.setColorFilter(
                        ContextCompat.getColor(this, R.color.yellow)
                    )
                }
                "dog" -> {
                    binding.dogImage.setColorFilter(
                        ContextCompat.getColor(this, R.color.yellow)
                    )
                }
                "fish" -> {
                    binding.fishImage.setColorFilter(
                        ContextCompat.getColor(this, R.color.yellow)
                    )
                }
            }
        }else {
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
        binding.returnButton.setColorFilter(
            ContextCompat.getColor(this, R.color.blue)
        )
        this.catSentences = resources.getStringArray(R.array.cat_sentences).toMutableList()
        this.dogSentences = resources.getStringArray(R.array.dog_sentences).toMutableList()
        this.fishSentences = resources.getStringArray(R.array.fish_sentences).toMutableList()
        setObserver()
        sentenceLiveData.value = getString(R.string.start_text)
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
                    sentenceLiveData.value = getString(R.string.no_more_phrases_of_cat_text)
                } else {
                    sentenceLiveData.value = catSentences.random()
                }
            } else if (selectedAnimal == "dog") {
                if(dogSentences.isEmpty()) {
                    sentenceLiveData.value = getString(R.string.no_more_phrases_of_dog_text)
                } else {
                    sentenceLiveData.value = dogSentences.random()
                }
            } else if (selectedAnimal == "fish") {
                if(fishSentences.isEmpty()) {
                    sentenceLiveData.value = getString(R.string.no_more_phrases_of_fish_text)
                } else {
                    sentenceLiveData.value = fishSentences.random()
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
            binding.randomSentence.text.toString() != getString(R.string.start_text) &&
            !binding.randomSentence.text.startsWith(getString(R.string.no_more_phrases_text))
            ) {
            when (selectedAnimal) {
                "fish" -> {
                    fishSentences.remove(binding.randomSentence.text.toString())
                }
                "dog" -> {
                    dogSentences.remove(binding.randomSentence.text.toString())
                }
                "cat" -> {
                    catSentences.remove(binding.randomSentence.text.toString())
                }
            }
            Toast.makeText(
                applicationContext,
                "Frase removida!",
                Toast.LENGTH_SHORT
            ).show()
            sentenceLiveData.value = getString(R.string.start_text)
        }
        return true
    }

    private fun setObserver() {
        sentenceLiveData.observe(this) { sentence ->
            binding.randomSentence.text = sentence
        }
    }
}