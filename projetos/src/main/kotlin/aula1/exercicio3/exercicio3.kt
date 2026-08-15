package org.example.aula1.exercicio3

import kotlin.math.pow
import kotlin.math.sqrt

class Point(val x: Double, val y: Double, val radius: Double) {}

fun main() {
    // Ler dados
    // -- Ponto 1
    print("Digite uma coordenada X: ")
    var x1: Double = readln().toDouble()
    print("Digite uma coordenada Y: ")
    var y1: Double = readln().toDouble()
    print("Digite um valor de raio: ")
    var radius1: Double = readln().toDouble()

    // -- Ponto 2
    print("Digite outra coordenada X: ")
    var x2: Double = readln().toDouble()
    print("Digite outra coordenada Y: ")
    var y2: Double = readln().toDouble()
    print("Digite outro valor de raio: ")
    var radius2: Double = readln().toDouble()

    // Inicialização das pessoas
    val point1 = Point(x1, y1, radius1)
    val point2 = Point(x2, y2, radius2)

    if(sqrt(
            (point1.x - point2.x).pow(2) + (point1.y - point2.y).pow(2)
    ) <= point1.radius + point2.radius) {
        println("ACERTOU")
    } else {
        println("ERROU")
    }
}