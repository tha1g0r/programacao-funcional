package recursividade.exercicios

import scala.annotation.tailrec

def double(x: Int): Int = x + x
def halve(x: Int): Int = x / 2

def fastMultiply(a: Int, b: Int): Int =
    if b == 0 then 0
    else if b % 2 == 0 then double(fastMultiply(a, halve(b)))
    else a + fastMultiply(a, b - 1)

def fastMultiplyTail(a: Int, b: Int): Int =
    @tailrec
    def loopHelper(a: Int, b: Int, acc: Int): Int =
        if b == 0 then acc
        else if b % 2 == 0 then loopHelper(double(a), halve(b), acc)
        else loopHelper(a, b - 1, acc + a)

    loopHelper(a, b, 0)

@main def mainFastMultiply(): Unit =
    println(fastMultiply(6, 2))
    println(fastMultiply(4, 3))
    println(fastMultiplyTail(6, 2))
    println(fastMultiplyTail(4, 3))
