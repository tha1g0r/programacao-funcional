package recursividade.aula

import scala.annotation.tailrec

def factorialNaive(n: BigInt): BigInt =
    if (n <= 1) 1
    else n * factorialNaive(n - 1)

@tailrec
def factorialTailRecursive(n: BigInt, acc: BigInt = 1): BigInt =
    if (n <= 1) acc
    else factorialTailRecursive(n - 1, acc * n)

def factorial(n: BigInt): BigInt =
    @tailrec
    def loopHelper(el: BigInt, acc: BigInt = 1): BigInt =
        if (el <= 1) acc
        else loopHelper(el - 1, acc * el)
    
    if (n < 0) -1
    else loopHelper(n)

@main def fatorial(): Unit =
    println(factorialTailRecursive(21))
