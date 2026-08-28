package tratamentoerros.aula

def divideO(x: Int, y: Int): Option[Int] =
    if y == 0 then None
    else Some(x / y)

def expression(x: Int, y: Int, z: Int): Option[Int] =
    for
        q1 <- divideO(x, y)
        q2 <- divideO(x, z)
    yield q1 + q2

@main def mainOption(): Unit =
    println(expression(10, 0, 2)) // 10/0 + 10/2 -> None
