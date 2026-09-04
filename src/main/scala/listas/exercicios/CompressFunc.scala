package listas.exercicios

import scala.annotation.tailrec

def compress[A](xs: List[A]): List[A] = xs match
    case Nil => Nil
    case el :: Nil => List(el)
    case head :: tail =>
        if head == tail.head then compress(tail)
        else head :: compress(tail)

def compressTail[A](xs: List[A]): List[A] =
    @tailrec
    def loopHelper(l: List[A], acc: List[A]): List[A] = l match
        case Nil => acc.reverse
        case el :: Nil => (el :: acc).reverse
        case head :: tail =>
            if head == tail.head then loopHelper(tail, acc)
            else loopHelper(tail, head :: acc)
        
    loopHelper(xs, Nil)

def compressFold[A](xs: List[A]): List[A] =
    xs.foldLeft(List.empty[A])(
        (acc, el) =>
            acc match
                case last :: _ if last == el => acc
                case _ => el :: acc
    ).reverse

@main def mainCompressFunc(): Unit =
    val lista = List(1, 1, 2, 2, 3, 1, 1)

    println(compress(lista))
    println(compressTail(lista))
    println(compressFold(lista))
