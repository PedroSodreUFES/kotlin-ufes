package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = applicationContext.getSharedPreferences(
            "CHAVE",
            Context.MODE_PRIVATE

        )
        val nome = sp.getString("NOME", null)
        if(nome != null) {
            startActivity(Intent(this, PaginaPrincipal::class.java))
            finish()
        }

        binding.buttonSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (R.id.buttonSave == view.id) {
            var textTyped = binding.nameInput.text.toString()
            if (textTyped.trim().length < 3) {
                Toast.makeText(
                    applicationContext,
                    resources.getString(R.string.nameInputError),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                sp.edit().putString(
                    "NOME",
                    textTyped,
                ).apply()

                Toast.makeText(
                    applicationContext,
                    "Nome salvo!",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(Intent(this, PaginaPrincipal::class.java))
                finish()
            }
        }
    }
}