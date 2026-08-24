package recursividade.exercicios

import scala.annotation.tailrec

@tailrec
def gcd(a: Int, b: Int): Int =
    if b == 0 then a
    else gcd(b, a % b)

@main def mainMdc(): Unit =
    println(gcd(1224, 3412))
