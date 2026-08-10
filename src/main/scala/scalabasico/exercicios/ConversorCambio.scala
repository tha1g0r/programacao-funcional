package scalabasico.exercicios

// Utilizando os conceitos de interpolação e formatação de strings (interpolador f), defina uma função que receba um valor em Reais (BRL) e a taxa de câmbio de conversão para Dólares (USD), e retorne uma string formatada no seguinte padrão: "R$ XXX.XX equivalem a US$ YYY.YY". Ambos os valores numéricos devem ser apresentados obrigatoriamente com exatamente duas casas decimais.

@main def conversorCambio(): Unit =
    def conversao(reais: Float, taxa: Float): String =
        val dolares = reais / taxa
        f"R$$ $reais%.2f equivalem a US$$ $dolares%.2f"

    println(conversao(100, 5.1))
