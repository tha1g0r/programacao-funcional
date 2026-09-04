package listas.exercicios

import scala.annotation.tailrec

def filter[A](xs: List[A])(p: A => Boolean): List[A] = xs match
    case Nil => Nil
    case head :: tail =>
        if p(head) then head :: filter(tail)(p)
        else filter(tail)(p)

def filterTail[A](xs: List[A])(p: A => Boolean): List[A] =
    @tailrec
    def loopHelper(l: List[A], acc: List[A]): List[A] = l match
        case Nil => acc.reverse
        case head :: tail =>
            if p(head) then loopHelper(tail, head :: acc)
            else loopHelper(tail, acc)

    loopHelper(xs, Nil)

def filterFold[A](xs: List[A])(p: A => Boolean): List[A] =
    xs.foldRight(List.empty[A])(
        (x, acc) =>
        if p(x) then x :: acc
        else acc
    )

@main def mainFilterFunc(): Unit =
    val lista = (1 to 10).toList
    val predicado: Int => Boolean = _ % 2 == 0

    println(filter(lista)(predicado))
    println(filterTail(lista)(predicado))
    println(filterFold(lista)(predicado))
