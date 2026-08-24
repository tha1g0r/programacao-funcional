package recursividade.exercicios

import scala.annotation.tailrec

def fastPower(base: Double, exp: Int): Double =
    if exp <= 0 then 1.0
    else if exp % 2 == 0 then
        val half = fastPower(base, exp / 2)
        half * half
    else base * fastPower(base, exp - 1)

def fastPowerTail(base: Double, exp: Int): Double =
    @tailrec
    def loopHelper(b: Double, e: Int, acc: Double): Double =
        if e <= 0 then acc
        else if e % 2 == 0 then loopHelper(b * b, e / 2, acc)
        else loopHelper(b, e - 1, acc * b)

    loopHelper(base, exp, 1.0)
            

@main def mainFastPower(): Unit =
    println(fastPower(3, 3))
    println(fastPowerTail(3, 3))
