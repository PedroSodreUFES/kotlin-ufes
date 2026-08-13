package org.example.aula1.exercicio2

fun printSenhaInvalida() {
    print("SENHA INVALIDA")
}

fun printSenhaValida() {
    print("SENHA VALIDA")
}

fun validarSenha(senha: String): Int {
    if (senha.length < 8) {
        return 0
    }

    var flag: Int = 0
    for (x in senha) {
        if(x.toChar().isUpperCase()) {
            flag = 1;
            break;
        }
    }
    if (flag == 0) {
        return 0
    }

    flag = 0
    for (x in senha) {
        if(x.toChar().isDigit()) {
            flag = 1;
            break;
        }
    }
    if (flag == 0) {
        return 0
    }

    return 1
}

fun main() {
    print("Digite sua senha: ")
    var senha: String = readln()
    val n = validarSenha(senha)
    if(n.equals(0)) {
        printSenhaInvalida()
    } else {
        printSenhaValida()
    }
}