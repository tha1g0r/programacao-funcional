package listas.atividades

def f1[T](l1: List[T]): List[T] = {
    def f2(a: List[T], b: List[T]): List[T] = {
        if (a.isEmpty) b
        else f2(a.tail, a.head :: b)
    }

    f2(l1, Nil)
}

@main def mainHelper(): Unit =
    println(f1((1 to 5).toList))
