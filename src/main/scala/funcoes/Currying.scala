package funcoes

@main def currying(): Unit =
    def sum(x: Int)(y: Int)(z: Int): Int = x + y + z
    // equivalente a
    val soma = (x: Int) => (y: Int) => (z: Int) => x + y + z

    // aplicação parcial
    val add5 = sum(5)         // fixa x = 5, espera y
    val add5and10 = add5(10)  // fixa y = 10, espera z
    println(add5and10(20))    // 35
    println(add5and10(30))    // 45

    // notação de chaves
    def translate(dx: Double)(dy: Double)(f: Double => Double): Double => Double =
        t => f(t + dx) + dy

    val f3 = translate(1.0)(2.0) { t =>
        val base = t * t
        base + math.sin(t)
    }

    // currying automático
    def somar(x: Int, y: Int): Int = x + y
        val curriedSum = somar.curried  // Int => Int => Int
        val soma5 = curriedSum(5)
        soma5(10)  // 15
    
    // aplicação prática - DSLs
    def select(table: String)(fields: Seq[String]): String =
        s"SELECT ${fields.mkString(", ")} FROM $table"

    val professor = select("professor")  // fixa a tabela
    professor(Seq("name", "age"))        // "SELECT name, age FROM professor"

    // Dada a função curried abaixo, escreva o código para criar uma função descontoPremium que já fixa taxa = 0.20, e depois aplique-a a precoBase = 100.0
    def aplicarDesconto(taxa: Double)(precoBase: Double): Double =
        precoBase * (1 - taxa)
    
    val descontoPremium = aplicarDesconto(0.20)
    println(descontoPremium(100.0))
