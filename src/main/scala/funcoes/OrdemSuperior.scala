package funcoes

// recebendo função como argumento
def twice(f: Int => Int, x: Int): Int = f(f(x))

// retornando função como resultado
def multiplier(factor: Int): Int => Int =
    (x: Int) => x * factor

// combinando os dois
def translate(f: Double => Double, dx: Double, dy: Double): Double => Double =
    (t: Double) => f(t - dx) + dy

// checagem
def negation(f: Int => Boolean): Int => Boolean =
    (x: Int) => !f(x)

@main def hof(): Unit =
    println(
        twice(x => x + 1, 5) // 7
    )
    println(
        twice(x => x * 2, 5) // 20
    )

    println()
    println(
        multiplier(2)(5) // 10
    )
    println(
        multiplier(3)(5) // 15
    )
    println()

    // ---

    println(
        negation(x => x % 2 == 0)(3)
        // f: recebe x inteiro e retorna se x é par
        // negation aplica o contrário -> retorna se 3 não é par -> true
    )
