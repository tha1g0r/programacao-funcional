package listas.aula

// def f[A](xs: List[A]): B = xs match
//     case Nil => // caso base
//     case head :: tail => // combina head com f(tail)

def listSize[A](xs: List[A]): Int = xs match
    case Nil => 0
    case _ :: tail => 1 + listSize(tail)

def listSizeTailRec(xs: List[Any], acc: Int = 0): Int = xs match
    case Nil => acc
    case _ :: tail => listSizeTailRec(tail, acc + 1)

@main def mainRecursaoEstrutual(): Unit =
    ???