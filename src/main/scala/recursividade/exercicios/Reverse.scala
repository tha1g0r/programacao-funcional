package recursividade.exercicios

import scala.annotation.tailrec

def reverse[A](list: List[A]): List[A] =
    @tailrec
    def loopHelper(l: List[A], acc: List[A]): List[A] =
        if l.isEmpty then acc
        else loopHelper(l.tail, l.head :: acc)
    
    loopHelper(list, List())

@main def mainReverse(): Unit =
    println(reverse(List(1, 2, 3)))
