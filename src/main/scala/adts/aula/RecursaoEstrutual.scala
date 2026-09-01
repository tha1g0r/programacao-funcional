package adts.aula

sealed trait MyList[+A]
case object MyNil extends MyList[Nothing] // sem dados -> object
case class MyCons[+A](head: A, tail: MyList[A]) extends MyList[A] // tem dados -> class

def sum(list: MyList[Int]): Int = list match
    case MyNil => 0
    case MyCons(head, tail) => head + sum(tail)

def length[A](list: MyList[A], n: Int = 0): Int = list match
    case MyNil => n
    case MyCons(head, tail) => length(tail, n + 1)

@main def mainRecursaoEstrutural(): Unit =
    ???
