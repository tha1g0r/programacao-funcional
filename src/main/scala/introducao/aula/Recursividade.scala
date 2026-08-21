package introducao.aula

import scala.annotation.tailrec

@main def recursividade(): Unit =
    def somaNonTail(a: Int, b: Int): Int =
        if a > b then 0
        else a + somaNonTail(a + 1, b)  // "a +" fica pendente -> empilha

    @tailrec // força o compilador a garantir que uma função seja tail-recursive (opcional)
    def somaTail(a: Int, b: Int, acc: Int = 0): Int =
        if a > b then acc
        else somaTail(a + 1, b, acc + a)  // nada pendente depois -> otimizável

    def fatorial(n: Int): Int =
        if n <= 1 then 1
        else n * fatorial(n - 1)

    @tailrec
    def fatorialTail(n: Int, acc: Int = 1): Int =
        if n <= 1 then acc
        else fatorialTail(n - 1, acc * n)  // multiplicação já embutida no acc
