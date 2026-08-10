package scalabasico.exercicios

@main def decomposicaoDigitos(): Unit =
    def decompor(n: Int): List[Int] =
        if n < 0 then Nil
        else
            val u = n % 10
            val d = (n / 10) % 10
            val c = (n / 100) % 10
            val m = n / 1000
            List(m, c, d, u)

    val n = -3
    println(decompor(n))
