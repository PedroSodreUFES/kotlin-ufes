
package com.example.app3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app3.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtCep.text = "CEP: ${intent.getStringExtra("cep") ?: ""}"
        binding.txtLogradouro.text = "Logradouro: ${intent.getStringExtra("logradouro") ?: ""}"
        binding.txtBairro.text = "Bairro: ${intent.getStringExtra("bairro") ?: ""}"
        binding.txtCidade.text = "Cidade: ${intent.getStringExtra("cidade") ?: ""}"
        binding.txtUf.text = "UF: ${intent.getStringExtra("uf") ?: ""}"

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
