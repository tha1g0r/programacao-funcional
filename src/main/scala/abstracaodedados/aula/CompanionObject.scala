package abstracaodedados.aula

import abstracaodedados.aula.Pair

class PositivePairCompanion private (override val first: Int, override val second: Int) extends Pair[Int](first, second) {
    // sem require
    override def name = "PositivePairCompanion"

    // Como o construtor é private, ninguém de fora pode chamar new PositivePair(...) diretamente — só o companion object (via apply) consegue, e ele devolve Option em vez de lançar exceção. Isso restaura a transparência referencial.
}

object PositivePairCompanion {
    def apply(first: Int, second: Int): Option[PositivePairCompanion] =
        if (first > 0 && second > 0) Some(new PositivePairCompanion(first, second))
        else None
}

@main def mainCompanionObject(): Unit =
    println(PositivePairCompanion(1, 2)) // Some(PositivePairCompanion(1, 2))
    println(PositivePairCompanion(-1, 2)) // None
