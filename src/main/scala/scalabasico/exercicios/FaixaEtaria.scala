package scalabasico.exercicios

@main def faixaEtaria(): Unit =
    def classificacaoIdade(idade: Int): String =
        if (idade < 0) ""
        else if (idade <= 12) "criança"
        else if (idade <= 17) "adolescente"
        else if (idade <= 59) "adulto"
        else "idoso"

    val idade = 21
    println(classificacaoIdade(idade))
