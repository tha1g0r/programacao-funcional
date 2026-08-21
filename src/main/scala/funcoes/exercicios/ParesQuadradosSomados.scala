package funcoes.exercicios

def paresAoQuadradoSomados(l: List[Int]): Int =
    l.filter(_ % 2 == 0).map(math.pow(_, 2)).reduce(_ + _).toInt

@main def paresQuadradosSomados(): Unit =
    val lista = List(1, 2, 3, 4, 5)
    println(
        paresAoQuadradoSomados(lista)
    )
