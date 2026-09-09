package laziness.atividades

@main def mainHelper(): Unit =
    val xAnsioso =
        println("Avaliando xAnsioso") // imprime aqui mesmo
        42

    lazy val xPreguicoso =
        println("Avaliando xPreguicoso") // não imprime
        42

    // println(xAnsioso)
    // println(xPreguicoso)
