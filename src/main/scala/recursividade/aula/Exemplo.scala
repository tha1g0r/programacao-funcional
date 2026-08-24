package recursividade.aula

import scala.annotation.tailrec

def recursiveSum(a: Long, b: Long): Long =
    if (a > b) 0
    else a + recursiveSum(a + 1, b)

@tailrec
def tailRecursiveSum(a: Long, b: Long, acc: Long = 0): Long =
    if (a > b) acc
    else tailRecursiveSum(a + 1, b, acc + a)

@main def exemplo(): Unit =
    println(recursiveSum(3, 4))
    println(tailRecursiveSum(3, 4))
