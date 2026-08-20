package org.example.aula3.exercicio1

import kotlin.math.floor

class Area(var name: String, var id: String, var capacity: Int)
class Person(var name: String, var id: String, var birthDate: String, var houseId: String)
class Reservation(val person: Person, val area: Area, val date: String, val guests: Int) {
    fun print() {
        println("--------- RESERVA ----------- ")
        println("Morador:")
        println("Nome: ${person.name}")
        println("CPF: ${person.id}")
        println("Data de Nascimento: ${person.birthDate}")
        println("Residência: ${person.houseId}")
        println()
        println("Area reservada:")
        println("Nome: ${area.name}")
        println("Id: ${area.id}")
        println("Capacidade: ${area.capacity}")
        println("Data de reserva: $date")
        println()
        println("Quantidade de convidados: $guests")
        println("Taxa de ocupação: ${floor(guests.toDouble()/area.capacity * 100)}%")
        println("------------------------------")
    }
}

fun main() {
    val areaList: MutableList<Area> = mutableListOf()
    val peopleList: MutableList<Person> = mutableListOf()
    val reservationList: MutableList<Reservation> = mutableListOf()

    print("Type the number of areas for booking: ")
    val numberAreas = readln().toInt()
    repeat(numberAreas) {
        print("Type the area name: ")
        val name = readln()
        print("Type the area id: ")
        val id = readln()
        print("Type the area capacity: ")
        val capacity = readln().toInt()
        areaList.add(Area(name, id, capacity))
    }

    print("Type the number of people: ")
    val numberPeople = readln().toInt()
    repeat(numberPeople) {
        print("Type the person name: ")
        val name = readln()
        print("Type the person id: ")
        val id = readln()
        print("Type the person birth date: ")
        val birthDate = readln()
        print("Type the person residence: ")
        val residence = readln()
        peopleList.add(Person(name, id, birthDate, residence))
    }

    while(true) {
        print("Type the option(F or R): ")
        val option = readln()
        if(option == "F") {
            break
        } else if(option == "R") {
            print("Type the area id: ")
            val areaId = readln()
            val area = areaList.find { it.id == areaId }
            if(area == null) {
                print("Invalid area")
                continue
            }
            print("Type the person id: ")
            val personId = readln()
            val person = peopleList.find { it.id == personId }
            if(person == null) {
                print("Invalid person")
                continue
            }
            print("Type the bookingDate: ")
            val bookingDate = readln()
            print("Type the number of guests: ")
            val guests = readln().toInt()
            reservationList.add(Reservation(person, area, bookingDate, guests))
        }
    }

    for(reservation in reservationList) {
        reservation.print()
    }
}