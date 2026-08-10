package scalabasico

import scala.annotation.tailrec

@main def listas(): Unit =
    val empty = Nil // ou List()

    val numbers = List(2, 3, 4) 
    val newNumbers = 1 :: numbers // List(1, 2, 3, 4)
    val another = 0 :: 1 :: numbers // List(0, 1, 2, 3, 4)

    newNumbers.head // 1
    newNumbers.tail // List(2, 3, 4)

    @tailrec
    def soma(lista: List[Int], acc: Int = 0): Int =
        if lista.isEmpty then acc
        else soma(lista.tail, acc + lista.head)

    println(soma(List(0, 1, 2, 3, 4, 5))) // 15
