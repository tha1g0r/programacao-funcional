package laziness.aula

@main def mainIterator(): Unit =
    val numbersIterator = LazyList.range(1, 1000).iterator
    println(numbersIterator.sum) // 499500 — consome tudo
    println(numbersIterator.size) // 0 — já não sobrou nada

    val numbersView = (1 to 1000).view
    println(numbersView.sum)             // 500500
    println(numbersView.size)            // 1000
    println(numbersView.sum / numbersView.size)  // 500 — funciona, sem erro
