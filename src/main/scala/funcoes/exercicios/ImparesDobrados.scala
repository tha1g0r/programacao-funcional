package funcoes.exercicios

def dobraImpares(l: List[Int]): List[Int] =
    l.filterNot(_ % 2 == 0).map(_ * 2)

@main def imparesDobrados(): Unit =
    val lista = List(1, 2, 3, 4, 5)
    println(
        dobraImpares(lista)
    )
