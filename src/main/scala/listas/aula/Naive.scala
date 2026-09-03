package listas.aula

import scala.annotation.tailrec

def reverseNaive[A](xs: List[A]): List[A] = xs match
    case Nil => Nil
    case head :: tail => reverseNaive(tail) :+ head
    // O(n²), não O(n)

def reverseTailRec[A](xs: List[A]): List[A] =
    @tailrec
    def loopHelper(remaining: List[A], ys: List[A]): List[A] = remaining match
        case Nil => ys
        case head :: tail => loopHelper(tail, head :: ys)

    loopHelper(xs, Nil)

def reverseFold[A](xs: List[A]): List[A] =
    xs.foldLeft(List.empty[A])((acc, x) => x :: acc)

@main def mainNaive(): Unit =
    ???
