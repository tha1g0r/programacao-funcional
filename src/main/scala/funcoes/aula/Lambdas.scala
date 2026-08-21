package funcoes.aula

@main def lambdas(): Unit =
    val add: (Int, Int) => Int =
        (x, y) => x + y
    println(add(3, 7))
