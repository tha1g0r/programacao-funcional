package recursividade.atividades

import scala.annotation.tailrec

@main def mainHelper(): Unit =
    def alpha(x: Int): Int =
        if x <= 0 then 0
        else x * x + alpha(x - 1)
        // soma dos quadrados de n a 1 (ou de 1 a n)
    // println(alpha(7)) // 49 + 36 + 25 + 16 + 9 + 4 + 1 + 0 = 140

    def g(n: Int, acc: Int = 0): Int =
        if n <= 0 then acc
        else g(n - 1, acc + 1)
        // acc é um contador
    // println(g(30)) // 30

    def produtoImpares(n: Int): Int = {
        var produto = 1
        var i = 1
        while (i <= n) {
            if (i % 2 == 1) {
                produto *= i
            }
            i += 1
        }
        return produto
    }
    println(produtoImpares(10)) // 1 * 3 * 5 * 7 * 9 = 945

    def RecProdutosImpares(n: Int): Int =
        @tailrec
        def loopHelper(i: Int, produto: Int): Int =
            if i > n then produto
            else if i % 2 == 1 then loopHelper(i + 1, produto * i)
            else loopHelper(i + 1, produto)
        
        loopHelper(1, 1)
    println(RecProdutosImpares(10))
    