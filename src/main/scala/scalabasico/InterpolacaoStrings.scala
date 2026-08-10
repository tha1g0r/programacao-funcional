package scalabasico

@main def interpolacaoStrings(): Unit =
    val name = "John Doe"
    val age = 30
    println(s"Name: $name, Age: $age")

    println(s"Random: ${scala.util.Random.nextInt(100)}")

    println(f"Sine: ${math.sin(math.Pi / 2)}%.2f")
    println(f"Value of pi: ${math.Pi}%.4f")
