package scalabasico

@main def expressaoIf(): Unit =
    val x = 10
    val y = 20
    val max = if (x > y) x else y
    println(s"Max: $max") // 20

    val totalItems = 8
    val price =
        if(totalItems > 10)
            val pricePerItem = 100
            val tax = 0.1
            totalItems * pricePerItem * (1 + tax)
        else
            val pricePerItem = 150
            val comission = 0.2
            totalItems * pricePerItem * (1 + comission)
    println(s"Price: $price") // 1440.0

    val resultado = if (5 > 3) "sim": Unit // o mesmo que apenas if (5 > 3) "sim"
    println(s"Resultado = $resultado") // () -> Unit
    println(s"Tipo de resultado: ${resultado.getClass()}") // void
