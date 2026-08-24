package recursividade.aula

import scala.annotation.tailrec

def declarativeSum(a: Long, b: Long): Long = {
    @tailrec
    def loopHelper(i: Long, sum: Long, b: Long): Long =
        if (i > b) sum
        else loopHelper(i + 1, sum + i, b)

    if (a > b) 0
    else loopHelper(a, 0, b)
}

def countDown(n: Int): Unit = {
    var i = n
    while (i > 0) {
        println(i)
        i -= 1
    }
}


def RecCountDown(n: Int): Unit = {
    @tailrec
    def loopHelper(n: Int): Unit =
        if n <= 0 then ()
        else
            println(n)
            loopHelper(n - 1)

    loopHelper(n)
}

@main def imperativoRecursivo(): Unit =
    println(countDown(5))
    println(RecCountDown(5))
