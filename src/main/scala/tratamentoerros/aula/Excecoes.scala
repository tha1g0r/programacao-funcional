package tratamentoerros.aula

def divideException(x: Int, y: Int): Int =
    if y == 0 then throw new ArithmeticException("Division by zero")
    else x / y

def divideOption(x: Int, y: Int): Option[Int] =
    if y == 0 then None
    else Some(x / y)

@main def mainExcecoes(): Unit =
    // println(divideException(10, 0)) // quebra o funcionamento do codigo
    println(divideException(10, 2))
    // println(divideException(10, 0) + divideException(10, 2)) // quebra o codigo

    println(divideOption(10, 0))
    println(divideOption(10, 2))
    // println(divideOption(10, 0) + divideOption(10, 2)) // + não existe para Option[Int]
