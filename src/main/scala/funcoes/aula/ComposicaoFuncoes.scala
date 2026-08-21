package funcoes.aula

@main def composicaoFuncoes(): Unit =
    val f: Int => Int = x => x + 2
    val g: Int => Int = x => x * 3

    // andThen
    val fAndThenG = f andThen g // g(f(x)) = (x + 2) * 3 = 3x + 6
    println(
        fAndThenG(5) // 3 * 5 + 6 = 15 + 6 = 21
    )

    // compose
    val fComposeG = f compose g // f(g(x)) = 3x + 2
    println(
        fComposeG(5) // 3 * 5 + 2 = 15 + 2 = 17
    )

    // com def
    def somarDois(x: Int) = x + 2
    def triplicar(x: Int) = x * 3
    val pipeline: Int => Int = somarDois andThen triplicar
    println(
        pipeline(5) // 21
    )

    // composição aplicada a pipelines inteiros de coleção
    case class Transaction(id: String, price: Double, active: Boolean)

    val auditPipeline: List[Transaction] => List[Transaction] =
        ledger => ledger
                  .filter(_.active)
                  .map(t => t.copy(price = t.price * 0.95))
    
    val metricsPipeline: List[Transaction] => List[Double] =
        ledger => ledger
                  .filter(_.price > 100.0)
                  .map(_.price)

    val fullPipeline: List[Transaction] => List[Double] =
        auditPipeline andThen metricsPipeline
