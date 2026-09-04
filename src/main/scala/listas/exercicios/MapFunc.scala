package listas.exercicios

import scala.annotation.tailrec

def map[A, B](xs: List[A])(f: A => B): List[B] = xs match
    case Nil => Nil
    case head :: tail => f(head) :: map(tail)(f)

def mapTail[A, B](xs: List[A])(f: A => B): List[B] =
    @tailrec
    def loopHelper(l: List[A], acc: List[B]): List[B] = l match
        case Nil => acc.reverse
        case head :: tail => loopHelper(tail, f(head) :: acc)
    
    loopHelper(xs, Nil)

def mapFold[A, B](xs: List[A])(f: A => B): List[B] =
    xs.foldRight(List.empty[B])(
        (x, acc) =>
            f(x) :: acc
    )

@main def mainMapFunc(): Unit =
    val lista = (1 to 5).toList
    val func: Int => Int = n => n * n

    println(map(lista)(func))
    println(mapTail(lista)(func))
    println(mapFold(lista)(func))
