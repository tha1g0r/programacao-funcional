package recursividade.exercicios

import scala.annotation.tailrec

def power(base: Double, exp: Int): Double =
    if exp == 0 then 1.0
    else base * power(base, exp - 1)

def powerTail(base: Double, exp: Int): Double =
    @tailrec
    def loopHelper(e: Int, acc: Double): Double =
        if e == 0 then acc
        else loopHelper(e - 1, acc * base)

    loopHelper(exp, 1.0)

@main def mainPower(): Unit =
    println(power(3, 3))
    println(powerTail(3, 3))
