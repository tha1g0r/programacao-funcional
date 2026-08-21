package funcoes.exercicios

def avgTemperature(temps: List[(Int, Double)], minTimestamp: Int): Double =
    val registrosValidos = temps
                           .filter(_._2 >= 0)
                           .filter(_._1 >= minTimestamp)
    val temperaturas = registrosValidos.map(_._2)

    val s = temperaturas.reduce(_ + _)
    val n = temperaturas.length
    s/n

@main def sensorTemperatura(): Unit =
    val lista = List(
        (1678886400, 25.5),
        (1678972800, 26.1),
        (1679059200, -60.0),
        (1679145600, 24.8),
        (1679232000, 27.0),
        (1679318400, 25.9)
    )
    println(
        avgTemperature(lista, 1679145600)
    )
