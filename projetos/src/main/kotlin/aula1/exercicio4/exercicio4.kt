package org.example.aula1.exercicio4

import java.util.Locale

fun PrintInvalidProcess() {
    println("Relação inválida por algum dos seguintes motivos:\n" +
            "\t1- Moeda Inválida.\n" +
            "\t2- Moeda Inexistente.\n" +
            "\t3- Moedas Iguais.\n")
}

fun isValidCurrency(currency: String): Boolean {
    if (currency.equals("USD") || currency.equals("EUR") || currency.equals("BRL"))
        return true
    else return false
}

fun formatNumber(value: Double): String {
    return "%.2f".format(Locale.US,value)
}

fun main() {
    // Checar valores
    print("Digite o valor a ser convertido: ")
    val x: String = readln()
    val value = x.toDouble()

    print("Digite a moeda original: ")
    val originalCurrency = readln().uppercase()
    if (!isValidCurrency(originalCurrency)) {
        PrintInvalidProcess()
        return
    }

    print("Digite a nova moeda: ")
    val newCurrency = readln().uppercase()
    if (!isValidCurrency(newCurrency)) {
        PrintInvalidProcess()
        return
    }

    if(newCurrency.equals(originalCurrency)) {
        PrintInvalidProcess()
        return
    }

    // Realizar conversão
    when(originalCurrency) {
        "USD" -> {
            when (newCurrency) {
                "BRL" -> {
                    println("${formatNumber(value * 5)} BRL")
                }
                "EUR" -> {
                    println("${formatNumber(value * 0.85)} EUR")
                }
            }
        }
        "EUR" -> {
            when (newCurrency) {
                "BRL" -> {
                    println("${formatNumber(value * 6)} BRL")
                }
                "USD" -> {
                    println("${formatNumber(value / 0.85)} USD")
                }
            }
        }
        "BRL" -> {
            when (newCurrency) {
                "EUR" -> {
                    println("${formatNumber(value / 6)} EUR")
                }
                "USD" -> {
                    println("${formatNumber(value / 5)} USD")
                }
            }
        }
    }
}