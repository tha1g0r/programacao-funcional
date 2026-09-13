package abstracoesalgebricas.aula

@main def mainCats(): Unit =
    import cats.Semigroup
    import cats.syntax.semigroup.*

    println(1 |+| 2)              // 3
    println("a" |+| "b")          // "ab"
    println(List(1,2) |+| List(3)) // List(1,2,3)

    import cats.Monoid
    import cats.syntax.monoid.*
    import cats.syntax.foldable.*

    println(Monoid[Int].empty)     // 0
    println(List(1,2,3).combineAll) // Cats já traz combineAll pronto (com cats.syntax.foldable)
