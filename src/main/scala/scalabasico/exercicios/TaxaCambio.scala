package scalabasico.exercicios

@main def taxaCambio(): Unit =
    def conversao(reais: Float, taxa: Float): String =
        val dolares = reais / taxa
        f"R$$ $reais%.2f equivalem a US$$ $dolares%.2f"

    println(conversao(100, 5.1))
