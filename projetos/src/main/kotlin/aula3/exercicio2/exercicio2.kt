package org.example.aula3.exercicio2

interface ObraPrint {
    fun printObra()
}

abstract class Obra(val title: String, val author: String, val year: Int) : ObraPrint {
    abstract override fun printObra()
}

class Article(val journal: String, val pages: Int, title: String, author: String, year: Int) :
    Obra(title, author, year), ObraPrint {
    override fun printObra() {
        println("- - - Artigo - - -")
        println("Titulo: $title")
        println("Autor: $author")
        println("Jornal: $journal")
        println("Ano: $year")
        println("Num. Paginas: $pages")
        println("- - - - - - - - -")
    }
}

class Book(val editor: String, title: String, author: String, year: Int) :
    Obra(title, author, year), ObraPrint {
    override fun printObra() {
        println("- - - Livro - - -")
        println("Titulo: $title")
        println("Autor: $author")
        println("Editora: $editor")
        println("Ano: $year")
        println("- - - - - - - - -")
    }
}

fun printMenu() {
    println("L - Type L to register a book")
    println("A - Type A to register an article")
    println("E - Type E to more functions")
    println("F - Type F to stop the app")
    print("Type your option: ")
}

fun printSubMenu() {
    println("Funcionalidades:")
    println(
        "LISTAR ACERVO\n" +
                "LISTAR LIVROS\n" +
                "LISTAR ARTIGOS\n" +
                "LISTAR AUTOR\n" +
                "LISTAR ANO"
    )
    print("Sua opção: ")
}

fun main() {
    val obrasList: MutableList<Obra> = mutableListOf()

    while (true) {
        printMenu()
        val option = readlnOrNull()
        if (option == null) continue else if (option == "L") {
            print("Digite o título da obra: ")
            val title = readln()
            print("Digite o autor da obra: ")
            val author = readln()
            print("Digite a editora da obra: ")
            val editor = readln()
            print("Digite o ano de publicação da obra: ")
            val year = readln().toInt()
            obrasList.add(Book(editor, title, author, year))
        } else if (option == "A") {
            print("Digite o título da obra: ")
            val title = readln()
            print("Digite o autor da obra: ")
            val author = readln()
            print("Digite o jornal da obra: ")
            val journal = readln()
            print("Digite o ano de publicação da obra: ")
            val year = readln().toInt()
            print("Digite o número de páginas da obra: ")
            val pages = readln().toInt()
            obrasList.add(Article(journal, pages, title, author, year))
        } else if (option == "E") {
            printSubMenu()
            val option = readlnOrNull()
            if (option == null) continue else if (option == "LISTAR ACERVO") {
                println("- - - LISTA DE TODOS OS ITENS DA BIBLIOTECA - - -")
                for (obra in obrasList) {
                    obra.printObra()
                }
            } else if (option == "LISTAR LIVROS") {
                println("- - - LISTA DE TODOS OS LIVROS DA BIBLIOTECA - - -")
                for (obra in obrasList) {
                    if (obra is Book) {
                        obra.printObra()
                    }
                }
            } else if (option == "LISTAR ARTIGOS") {
                println("- - - LISTA DE TODOS OS ARTIGOS DA BIBLIOTECA - - -")
                for (obra in obrasList) {
                    if (obra is Article) {
                        obra.printObra()
                    }
                }
            } else if (option == "LISTAR AUTOR") {
                print("Digite o nome do autor: ")
                val authorName = readln()
                println("- - - LISTA DE TODOS OS ITENS DE UM AUTOR - - -")
                println("Nome do autor: $authorName")
                for (obra in obrasList) {
                    if (obra.author == authorName) {
                        obra.printObra()
                    }
                }
            } else if (option == "LISTAR ANO") {
                print("Digite o ano das publicações: ")
                val year = readln().toInt()
                print("- - - LISTA DE TODOS OS ITENS DE UM ANO - - -")
                println("- Ano: $year")
                for (obra in obrasList) {
                    if (obra.year == year) {
                        obra.printObra()
                    }
                }
            }
        } else if (option == "F") {
            break
        }
    }
}