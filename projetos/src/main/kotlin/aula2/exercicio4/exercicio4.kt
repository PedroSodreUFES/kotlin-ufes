package org.example.aula2.exercicio4

class Student(var name: String, var id: String, var grade: Double) {}

fun main() {
    var students = mutableListOf<Student>()
    while(true){
        print("Type name, id and grade of the student: ")
        var text = readln()
        if(text == "FIM") {
            break
        }

        var fields: List<String> = text.split(" ")
        var name = fields[0]
        var id = fields[1]
        var grade = fields[2].toDouble()

        students.add(Student(name, id, grade))
    }

    var totalGrades = 0.0
    for (student in students){
        totalGrades += student.grade
    }

    println("Média das notas: ${totalGrades / students.size}")
}