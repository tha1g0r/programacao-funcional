package scalabasico.exercicios

@main def conceitoNota(): Unit =
    def conversaoNota(nota: Float): String =
        if 0 <= nota && nota <= 5 then "F"
        else if nota < 7 then "D"
        else if nota < 9 then "C"
        else if nota < 10 then "B"
        else if nota == 10 then "A"
        else ""

    println(conversaoNota(7.4))
 