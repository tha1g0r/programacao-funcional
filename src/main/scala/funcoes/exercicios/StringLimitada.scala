package funcoes.exercicios

def limitaSize(l: List[String], inf: Int, sup: Int): List[String] =
    val dentroLimite: String => Boolean =
        s => s.length >= inf && s.length <= sup
    l.filter(dentroLimite(_))
    // l.filter(s => s.length >= inf && s.length <= sup)

@main def stringLimitada(): Unit =
    val lista = List("Scala", "Java", "Python", "C++")
    println(
        limitaSize(lista, 3, 5)
    )
