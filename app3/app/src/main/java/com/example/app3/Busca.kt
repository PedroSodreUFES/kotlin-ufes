package com.example.app3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app3.api.RetrofitClient
import com.example.app3.databinding.ActivityBuscaBinding
import com.example.app3.models.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Busca : AppCompatActivity() {

    private lateinit var binding: ActivityBuscaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuscaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBuscar.setOnClickListener {
            val cep = binding.editCep.text.toString()
            if (cep.length != 8 || !cep.all { it.isDigit() }) {
                Toast.makeText(
                    this,
                    "CEP inválido",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                RetrofitClient.api.buscarCep(cep)
                    .enqueue(object : Callback<Endereco> {
                        override fun onResponse(
                            call: Call<Endereco>,
                            response: Response<Endereco>
                        ) {
                            if (response.isSuccessful) {
                                val endereco = response.body()
                                if (endereco == null) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Resposta inválida",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    val intent = Intent(
                                        applicationContext,
                                        Resultado::class.java
                                    )
                                    intent.putExtra("cep", endereco.cep)
                                    intent.putExtra("logradouro", endereco.logradouro)
                                    intent.putExtra("bairro", endereco.bairro)
                                    intent.putExtra("cidade", endereco.localidade)
                                    intent.putExtra("uf", endereco.uf)
                                    startActivity(intent)
                                }
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "A requisição falhou",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onFailure(
                            call: Call<Endereco>,
                            t: Throwable
                        ) {
                            Toast.makeText(
                                applicationContext,
                                "A requisição falhou",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
            }
        }
    }
}
