package scalabasico.exercicios

@main def comissaoVendedor(): Unit =
    def calculoComissao(qtd: Int): Double =
        val comissao = 
            if qtd >= 500 then 2.0
            else if qtd >= 250 then 1.50
            else 1.0
        comissao * qtd

    val qtd = 6584
    println(f"Para $qtd: R$$ ${calculoComissao(qtd)}%.2f")
