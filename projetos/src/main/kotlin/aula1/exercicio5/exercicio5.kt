package org.example.aula1.exercicio5

fun encriptografar(message: String, deslocamento: Int) {
    val A = 'A'.hashCode()
    val Z = 'Z'.hashCode()
    val z = 'z'.hashCode()

    val divisor = Z - A
    val salto = deslocamento % divisor

    for (character in message.toCharArray()) {
        if (character.isUpperCase()) {
            var result = character.hashCode() + salto
            if (result > Z.hashCode()) {
                result -= divisor
            }
            print(result.toChar())
        } else if (character.isLowerCase()) {
            var result = character.hashCode() + salto
            if (result > z.hashCode()) {
                result -= divisor
            }
            print(result.toChar())
        } else {
            print(character)
        }
    }
}

fun descriptografar(message: String, deslocamento: Int) {
    val A = 'A'.hashCode()
    val Z = 'Z'.hashCode()
    val a = 'a'.hashCode()

    val divisor = Z - A
    val salto = deslocamento % divisor

    for (character in message.toCharArray()) {
        if (character.isUpperCase()) {
            var result = character.hashCode() - salto
            if (result < A.hashCode()) {
                result += divisor
            }
            print(result.toChar())
        } else if (character.isLowerCase()) {
            var result = character.hashCode() - salto
            if (result < a.hashCode()) {
                result += divisor
            }
            print(result.toChar())
        } else {
            print(character)
        }
    }
}

fun main() {
    print("Digite C para criptografar ou D para descriptografar: ")
    val mode = readln().uppercase()

    print("Digite o deslocamento: ")
    val number = readln().toInt()

    print("Digite a mensagem: ")
    val text = readln()

    when (mode) {
        "C" -> {
           encriptografar(text, number)
        }
        "D" -> {
            descriptografar(text, number)
        }
        else -> {
            println("Modo Inválido.")
        }
    }

}