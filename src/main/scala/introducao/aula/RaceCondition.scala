package introducao.aula

import scala.collection.parallel.CollectionConverters._

@main def raceCondition(): Unit =
    // ===== Concorrência imperativa =====
    class ContaImperativa:
        var saldo: Int = 0
        def depositar(valor: Int): Unit = saldo += valor // NÃO thread-safe

    val conta = ContaImperativa()

    // 10 threads, cada uma fazendo 1000 depósitos de 1 (esperado: 10000)
    val threads = (1 to 10).map { _ =>
        new Thread(() => {
            for _ <- 1 to 1000 do conta.depositar(1)
        })
    }

    threads.foreach(_.start())
    threads.foreach(_.join()) // espera todas terminarem

    println(s"Saldo final (Imperativo): ${conta.saldo}") // varia, geralmente < 10000

    // ===== Concorrência funcional =====
    val transacoes: List[Int] = List.fill(10000)(1) // lista imutável
    val saldoFinal = transacoes.par.reduce((acc, valor) => acc + valor)
    println(s"Saldo final (Funcional): $saldoFinal") // sempre 10000, consistente
