package scalabasico.exercicios

@main def classificadorTemperatura(): Unit =
    def classificacaoTemp(t: Double): List[String] =
        val c1 = "Congelante"
        val c2 = "Muito Frio"
        val c3 = "Frio"
        val c4 = "Fresco"
        val c5 = "Agradável"
        val c6 = "Quente"
        val c7 = "Muito Quente"

        if t < -10 then List(c1)
        else if t < 0 then List(c2)
        else if t == 0 then List(c2, c3)
        else if t < 10 then List(c3)
        else if t == 10 then List(c3, c4)
        else if t < 20 then List(c4)
        else if t == 20 then List(c4, c5)
        else if t < 30 then List(c5)
        else if t == 30 then List(c5, c6)
        else if t <= 40 then List(c6)
        else if t > 40 then List(c7)
        else List()

    val temp = 17
    println(s"Classificação da teperatura: ${classificacaoTemp(temp)}")
