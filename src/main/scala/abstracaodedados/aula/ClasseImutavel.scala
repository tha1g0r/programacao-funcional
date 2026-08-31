package abstracaodedados.aula

// Em Scala, a classe imutável básica se parece com isto:

class Pair[T](val first: T, val second: T) {
    def copy(first: T = this.first, second: T = this.second): Pair[T] =
        new Pair(first, second)

    def name = "Pair"
    override def toString: String = s"${name}($first, $second)"
}

class PairSemVal[T](first: T, second: T) {
    def name = "Pair"
    override def toString: String = s"${name}($first, $second)"
    // ok usar first aqui dentro
}

class PositivePair(override val first: Int, override val second: Int) extends Pair[Int](first, second) {
    require(first > 0 && second > 0, "Both elements must be positive integers")

    override def name = "PositivePair"

    // Pontos-chaves
        // - PositivePair herda copy, toString, etc. de Pair, mas como name foi sobrescrito, toString (herdado) automaticamente imprime "PositivePair(...)"
        // - require lança exceção se a condição falhar — isso é um efeito colateral, então o construtor deixa de ser referencialmente transparente (chamar new PositivePair(-1, 2) não é uma expressão "pura" — pode explodir)
}

@main def mainClasseImutavel(): Unit =
    val pair = new Pair(1, 2)
    println(s"pair: $pair")

    val modifiedPair = pair.copy(first = 3)
    println(s"modifiedPair: $modifiedPair")

    val p = new PairSemVal(1, 2)
    // println(p.first) // erro de compilação: value first is not a member of PairSemVal[Int]

    val positivePair = new PositivePair(1, 2)
    println(positivePair)

    val invalidPair = new PositivePair(-1, 2) // lança IllegalArgumentException
    println(invalidPair)
