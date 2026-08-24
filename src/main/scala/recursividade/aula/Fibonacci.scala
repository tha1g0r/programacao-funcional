package recursividade.aula

import scala.collection.mutable
import scala.annotation.tailrec

def fibonacciNaive(n: BigInt): BigInt =
    if (n == 0) BigInt(0)
    else if (n == 1) BigInt(1)
    else fibonacciNaive(n - 1) + fibonacciNaive(n - 2)

def memoize[I, O](f: I => O): I => O = {
    val cache = mutable.Map.empty[I, O]
    (arg: I) => cache.getOrElseUpdate(arg, f(arg))
}

val fibonacciMemoized: BigInt => BigInt = memoize { n =>
    if (n == 0) BigInt(0)
    else if (n == 1) BigInt(1)
    else fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2)
}

def fibonacciIterative(n: Int): Int = {
    if (n == 0) return 0
    if (n == 1) return 1
    var a = 0; var b = 1; var i = 2
    while (i <= n) { val temp = a + b; a = b; b = temp; i += 1 }
    b
}

def fibonacciTailRecursive(n: BigInt): BigInt = {
    @tailrec
    def loop(i: BigInt, a: BigInt, b: BigInt): BigInt =
        if (i > n) b
        else loop(i + 1, b, a + b)

    if (n == 0) 0
    else if (n == 1) 1
    else loop(2, 0, 1)
}

@main def fibonacci(): Unit =
    println(fibonacciNaive(12))
    println(fibonacciMemoized(12))
    println(fibonacciIterative(12))
    println(fibonacciTailRecursive(12))
