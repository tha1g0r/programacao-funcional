package listas.aula

@main def mainCompartilhamentoEstrutural(): Unit =
    val xs = List(2, 3, 4)
    val withOne = 1 :: xs // aloca 1 nó (1), aponta pro nó "2" de xs
    val withZero = 0 :: withOne // aloca 1 nó (0), aponta pro nó "1"
    // xs, withOne e withZero compartilham os mesmos nós 2, 3, 4 na memória — não existem cópias duplicadas deles
