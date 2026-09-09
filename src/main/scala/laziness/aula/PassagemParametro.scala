package laziness.aula

def add(x: => Int, y: => Int): Int = {
    println("add body started")
    println(s"Computing: $x + $y")  // usa x e y aqui (1ª vez cada)
    x + y                            // usa x e y de novo aqui (2ª vez cada)

    // Quando chamado com `add(expensiveComputation(3), expensiveComputation(4))`, cada `expensiveComputation` roda **duas vezes** — uma no `println`, outra no `x + y` — porque call-by-name não memoiza.
}

def addByNeed(x: => Int, y: => Int): Int = {
    lazy val cachedX = x
    lazy val cachedY = y
    println("add body started")
    println(s"Computing: $cachedX + $cachedY")  // 1ª avaliação, calcula e cacheia
    cachedX + cachedY                            // reusa o cache, não recalcula
}

@main def mainPassagemParametro(): Unit =
    ???
