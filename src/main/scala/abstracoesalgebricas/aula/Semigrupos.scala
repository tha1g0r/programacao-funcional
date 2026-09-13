package abstracoesalgebricas.aula

// em Scala, semigrupos são modelados como type classes

trait Semigroup[A]:
    def combine(x: A, y: A): A
    // para qualquer tipo `A`, um semigrupo precisa desse método

// o objeto `Semigroup` permite acessar nossas implementações
object Semigroup:
    def apply[A](using s: Semigroup[A]): Semigroup[A] = s

    extension [A](x: A)(using s: Semigroup[A])
        def |+|(y: A): A = s.combine(x, y)
        // nova operação chama `|+|`. Assim, em vez de escrever `Semigroup[Int].combine(2, 3)`, podemos escrever `2 |+| 3`

// implementação para `Int`
given intAdditionSemigroup: Semigroup[Int] with
    def combine(x: Int, y: Int): Int = x + y
    // `Semigroup[Int]` usa a adição como operação de combinação
