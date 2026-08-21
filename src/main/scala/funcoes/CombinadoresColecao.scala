package funcoes

@main def combinadoresColecao(): Unit =
    // map
    val numbers = List(1, 2, 3, 4, 5)
    val doubled = numbers.map(n => n * 2)
    println(s"numbers: $numbers\ndoubled: $doubled")

    // collect
    val mixedList = List("apple", 42, "banana", true, "cherry")
    val collected = mixedList.collect {
        case s: String => s.toUpperCase
        case i: Int => i * 2
    }
    println(s"\nmixedList: $mixedList\ncollected: $collected")

    // Dada val words = List("scala", "java", "python", "go"), escreva uma expressão usando map que produza uma lista com o comprimento de cada string: List(5, 4, 6, 2).
    val words = List("scala", "java", "python", "go")
    val sizes = words.map(s => s.size) // words.map(_.size)
    println(s"\nwords: $words\nsizes: $sizes")

    // filter
    val evenNumbers = numbers.filter(n => n % 2 == 0) // List(2, 4)
    // filterNot
    val oddNumbers = numbers.filterNot(n => n % 2 == 0) // List(1, 3, 5)

    // Dada val nums = List(3, 8, 1, 9, 4, 12, 6), escreva uma expressão usando filter que produza apenas os números maiores que 5.
    val nums = List(3, 8, 1, 9, 4, 12, 6)
    val greaterThan5 = nums.filter(_ > 5)
    println(s"\nnums: $nums\ngreaterThan5: $greaterThan5")

    // reduce
    val sum = numbers.reduce((acc, b) => acc + b) // 15

    // dobra
    val sumLeft = numbers.foldLeft(0)((acc, n) => acc + n) // 15
    val sumRight = numbers.foldRight(0)((n, acc) => acc + n) // .foldLeft(0)(_ + _)
    println(s"\nsumLeft: $sumLeft\nsumRight: $sumRight")

    numbers.foldLeft(0)(_ - _) // -15
    numbers.foldRight(0)(_ - _) // 3

    // Qual o resultado de List("a", "b", "c").foldLeft("")((acc, s) => acc + s)?
    println(
        s"\n${List("a", "b", "c").foldLeft("")((acc, s) => acc + s)}"
    )
