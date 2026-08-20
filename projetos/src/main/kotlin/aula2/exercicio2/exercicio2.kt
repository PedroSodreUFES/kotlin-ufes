package org.example.aula2.exercicio2

fun main() {
    print("Digite um numero: ")
    val number = readln().toInt()
    print("Digite seu texto: ")
    val text = readln()
    val textMap: MutableMap<String, Int> = mutableMapOf()

    for(word in text.split(" ")) {
        var key = word.lowercase()
        if(textMap.containsKey(key)) {
            var n = textMap[key]!!
            n+=1
            textMap[key] = n
        } else {
            textMap[key] = 0
        }
    }
}
