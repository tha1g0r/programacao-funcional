package laziness.aula

def makeFibonacci: LazyList[Int] = {
    def fibs(a: Int, b: Int): LazyList[Int] =
        a #:: fibs(b, a + b)
    fibs(0, 1)

    // Repare que fibs nunca tem um caso de parada — ele sempre retorna a #:: fibs(...). Isso só funciona porque #:: não avalia o segundo argumento (t: => LazyList[A]) imediatamente; ele fica "suspenso" até alguém pedir o próximo elemento com .tail.
}

@main def mainListaInfinita(): Unit =
    println(makeFibonacci.take(5).toList)
    // O padrão de fundo é sempre o mesmo, tipo o que vimos nos primos: fibs só roda sob demanda, uma vez por elemento pedido — nunca mais, nunca menos.
