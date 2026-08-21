package funcoes.aula

@main def orquestraCombinadores(): Unit =
    val numbers = List(1, 2, 3, 4, 5)
    println(s"numbers: $numbers")
    val result = numbers // 1, 2, 3, 4, 5
        .map(_ * 2) // 1, 4, 6, 8, 10
        .filter(_ % 3 == 0) // 6
        .reduce(_ + _) // 6
    println(s"result: $result")

    // exemplo mais "real"

    case class Transaction(id: String, category: String, price: Double)

    val ledger = List(
        Transaction("T1", "Electronics", 1200.00),
        Transaction("T2", "Books", 25.50),
        Transaction("T3", "Electronics", 150.00),
        Transaction("T4", "Electronics", 650.00),
        Transaction("T5", "Clothing", 80.00)
    )

    val eletronicsRevenue = ledger // T1, T2, T3, T4, T5
        .filter(_.category == "Electronics") // T1, T3, T4
        .filter(_.price > 500.00) // T1, T4
        .map(_.price) // 1200.00, 650.00
        .reduce(_ + _) // 1850.00

    // Dada a lista val prices = List(10.0, 250.0, 45.0, 300.0, 5.0), escreva um pipeline encadeado (filter + map + reduce) que calcule a soma dos preços acima de 40, aplicando um desconto de 10% em cada um antes de somar

    val prices = List(10.0, 250.0, 45.0, 300.0, 5.0)
    val precoFinal = prices
        .filter(_ > 40)
        .map(_ * 0.90)
        .reduce(_ + _)
    println(s"precoFinal: $precoFinal")
