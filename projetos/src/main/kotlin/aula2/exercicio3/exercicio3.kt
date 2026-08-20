package org.example.aula2.exercicio3

fun printValid() {
    println("DISPONIVEL")
}

fun printInvalid() {
    println("INDISPONIVEL")
}

fun main() {
    print("Digite sua gamertag desejada: ")
    val gamertag = readln()
    print("Digite todas as gamertags: ")
    val gamertags = readln()

    val garmertagsArray: List<String> = gamertags.split(" ")

    if(garmertagsArray.contains(gamertag)) {
        printInvalid()
    } else {
        printValid()
    }
}