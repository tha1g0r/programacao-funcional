package scalabasico

@main def expressaoBloco(): Unit =
    val result =
        val x = 10
        val y = 20
        x + y // última expressão = valor do bloco

    println(result) // 30

    val total =
        val a = 5
        val b = a * 2 // 10
        println("Calculando...")
        a + b
    
    println(total)
    // Calculando...
    // 15
    println(total) // não imprime "Calculando..."
