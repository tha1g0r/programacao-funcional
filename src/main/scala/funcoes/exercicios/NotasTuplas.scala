package funcoes.exercicios

def averageApproved(students: List[(String, Double)]): Double =
    val aprovados = students.filter(_._2 >= 7.0)
    val notasAprovadas = aprovados.map(_._2)

    val s = notasAprovadas.reduce(_ + _)
    val n = notasAprovadas.length
    s/n

@main def notasTuplas(): Unit =
    val lista = List(
        ("Alice", 8.5),
        ("Bob", 7.0),
        ("Charlie", 9.0),
        ("David", 6.5),
        ("Eve", 8.0)
    )
    println(
        averageApproved(lista)
    )
