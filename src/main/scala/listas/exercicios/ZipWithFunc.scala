package listas.exercicios

import scala.annotation.tailrec

def zipWith[A, B, C](xs: List[A], ys: List[B])(f: (A, B) => C): List[C] = (xs, ys) match
    case (h1 :: t1, h2 :: t2) => f(h1, h2) :: zipWith(t1, t2)(f)
    case _ => Nil

def zipWithTail[A, B, C](xs: List[A], ys: List[B])(f: (A, B) => C): List[C] =
    @tailrec
    def loopHelper(l1: List[A], l2: List[B], acc: List[C]): List[C] = (l1, l2) match
        case (h1 :: t1, h2 :: t2) => loopHelper(t1, t2, f(h1, h2) :: acc)
        case _ => acc.reverse
    
    loopHelper(xs, ys, Nil)

@main def mainZipWithFunc(): Unit =
    val lista1 = (1 to 5).toList
    val lista2 = (6 to 10).toList
    val func: (Int, Int) => Int = (a, b) => a + b
    println(lista1)
    println(lista2)

    println("======")
    println(zipWith(lista1, lista2)(func))
    println(zipWithTail(lista1, lista2)(func))
