package org.example.aula2.exercicio2

fun main() {
    print("Digite um numero: ")
    val number = readln().toInt()
    print("Digite seu texto: ")
    val text = readln()
    val textMap: MutableMap<String, Int> = mutableMapOf()
    var treatedText: String = ""

    for (character in text.toCharArray()) {
        if(character.isLetter() || character == ' ') {
            treatedText += character
        }
    }

    for(word in treatedText.split(" ")) {
        var key = word.lowercase()
        if(textMap.containsKey(key)) {
            var n = textMap[key]!!
            n+=1
            textMap[key] = n
        } else {
            textMap[key] = 1
        }
    }

    val mapList = textMap.toList().sortedBy { (_, value) -> value }.reversed()

    repeat(number) { i ->
        println("${mapList[i].first}: ${mapList[i].second}")
    }
}
