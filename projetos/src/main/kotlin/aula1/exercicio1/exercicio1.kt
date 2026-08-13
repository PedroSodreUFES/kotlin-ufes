package org.example.aula1.exercicio1

fun main() {
    print("Digite um número: ")
    var x = readln()
    var n: Int = x.toInt()
    var m: Int = 1
    for (a in 1..n) {
        for (j in 1..a) {
            if (j == a) {
                print(m)
            } else {
                print("$m ")
            }
            m++
        }
        println()
    }
}