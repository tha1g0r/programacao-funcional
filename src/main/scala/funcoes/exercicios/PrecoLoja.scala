package funcoes.exercicios

def calculateFinalPrice(cart: List[(Int, Double, Double)]): Double =
    val desconto: Double => Double =
        peso =>
            if peso <= 0.5 then 0.05
            else if peso < 1.0 then 0.10
            else if peso < 2.0 then 0.15
            else 0.20

    val frete: Double => Double =
        peso =>
            if peso <= 0.5 then 1.0
            else if peso < 1.0 then 1.5
            else if peso < 2.0 then 2.0
            else 3.0
    
    val totalPorItem = cart.map { item =>
        val preco = item._2
        val peso = item._3
        preco * (1 - desconto(peso)) + frete(peso)
    }

    val total = totalPorItem.reduce(_ + _)
    total

@main def precoLoja(): Unit =
    val lista = List(
        (1, 10.0, 0.5), // (id, preço, peso)
        (2, 20.0, 1.0),
        (3, 15.0, 0.8)
    )
    println(
        calculateFinalPrice(lista)
    )
