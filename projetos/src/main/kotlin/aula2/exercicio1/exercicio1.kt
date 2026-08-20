package org.example.aula2.exercicio1

class Product (val name: String, val amount : Int, val description: String? = "Sem descrição") {
    fun print() {
        println("Produto: ${this.name}")
        println("Quantidade em estoque: ${this.amount}")
        println("Descriçao: ${this.description}")
    }
}

fun main() {
    print("Type a product name: ")
    val productName = readln()

    print("Type the amount stored of product: ")
    val productAmount = readln().toInt()

    print("Type a product description: ")
    var productDescription: String? = readlnOrNull()
    if (productDescription.equals("")) {
        productDescription = null
    }

    var product: Product
    if(productDescription.equals(null)) {
        product = Product(productName, productAmount)
    } else {
        product = Product(productName, productAmount, productDescription)
    }
    product.print()
}