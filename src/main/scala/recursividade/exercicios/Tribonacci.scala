package recursividade.exercicios

import scala.annotation.tailrec

def tribonacci(n: Int): Int =
    if n <= 1 then 0
    else if n == 2 then 1
    else tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)

// def tribonacciTail(n: Int): Int =
//     @tailrec
//     def loopHelper(): Int =

@main def mainTribonacci(): Unit =
    println(tribonacci(6))
