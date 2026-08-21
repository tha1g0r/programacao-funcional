package funcoes

@main def closures(): Unit =
    def f(x: Int) = // : Int => Int
        val y = 2
        (z: Int) => x + y + z

    val c = f(3)
    println(
        c(4) // 3 + 2 + 4 = 9
    )

    def contador(inicio: Int): () => Int = {
        var n = inicio
        () => { n = n + 1; n }
    }
    val c1 = contador(0)
    println(c1())
    println(c1())
    println(c1())
