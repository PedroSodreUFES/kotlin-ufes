package org.example.aula2.exercicio5

class Candidate(var name: String, var id: String, var number: Int) {
    var votes = 0

    fun printWinner() {
        print("Candidato vencedor: ")
        print("$name ")
        repeat(id.length) { i ->
            if(i in 4..6 || i in 8..10) {
                print('*')
            } else {
                print(id[i])
            }
        }
        print(" com $votes votos.")
    }
}

fun main() {
    val candidates = mutableListOf<Candidate>()
    while(true) {
        print("Type the option: ")
        val option = readln()
        if(option == "FIM") {
            break
        }

        when(option) {
            "CAN" -> {
                print("Type the candidate name: ")
                val name = readln()
                print("Type the candidate id: ")
                val id = readln()
                print("Type the candidate number: ")
                val number = readln().toInt()
                candidates.add(Candidate(name,id,number))
            }
            "VOTO" -> {
                print("Type the candidate number: ")
                val number = readln().toInt()
                for(candidate in candidates) {
                    if(candidate.number == number) {
                        candidate.votes+=1
                        break
                    }
                }
            }
        }
    }

    val bestCandidate: Candidate? = candidates.maxByOrNull { it.votes }
    bestCandidate.let { it?.printWinner() }
}