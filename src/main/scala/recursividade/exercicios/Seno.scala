package recursividade.exercicios

def sine(x: Double): Double =
    if x.abs < 0.10 then x
    else 3 * sine(x / 3) - 4 * math.pow(sine(x / 3), 3)

@main def mainSeno(): Unit =
    println(sine(0)) // 0.0
    println(sine(math.Pi / 6)) // 0.5
    println(sine(math.Pi / 4)) // 0.707107
    println(sine(math.Pi / 3)) // 0.866025
    println(sine(math.Pi / 2)) // 1.0
