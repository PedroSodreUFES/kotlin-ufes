package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding :  ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button) {
            var salary = binding.salarioInput.text.toString().toDoubleOrNull()
            var expenses = binding.gastoInput.text.toString().toDoubleOrNull()
            var dependents = binding.dependentesInput.text.toString().toIntOrNull()

            if(salary == null || expenses == null || dependents == null) {
                Toast.makeText(
                    applicationContext,
                    "Campos Inválidos",
                    Toast.LENGTH_SHORT,
                ).show()
            } else {
                if(salary > 5000.0) {
                    var tax = salary * 0.275 - 908.73
                    binding.tax.text = tax.toString()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Você não precisa pagar imposto de renda.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    binding.tax.text = "0.00"
                }
            }
        }
    }
}