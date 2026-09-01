package adts.aula

case class Point(x: Double, y: Double)

@main def mainTiposProduto(): Unit =
    val p1 = Point(3.0, 4.0) // usa apply do companion object
    val p2 = p1.copy(y = 5.0) // Point(3.0, 5.0)
    println(p1 == Point(3.0, 4.0)) // true — igualdade estrutural, não referencial
