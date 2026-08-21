package introducao.aula

@main def primeiraClasse(): Unit =
    val square: Int => Int = x => x * x
    //         (sintexa de tipo) = (função lambda)
    println(square(5)) // 25

    val add: (Int, Int) => Int = (x, y) => x + y // recebe dois inteiros e retorna um inteiro
    println(add(3, 4)) // 7

    def cube(x: Int): Int = x * x * x
    val myFunc = cube // funciona como valor
    println(myFunc(3)) // 27
