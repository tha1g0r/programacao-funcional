package abstracoesalgebricas.aula

trait Monoid[A] extends Semigroup[A]:
    def empty: A

object Monoid:
    def apply[A](using m: Monoid[A]): Monoid[A] = m
    // permite acessar automaticamente a implementação correta para um tipo

    extension [A](x: A)(using s: Semigroup[A])
        infix def |+|(y: A): A = s.combine(x, y)

    extension [A: Monoid](xs: List[A])
        def combineAll: A =
        xs.foldLeft(Monoid[A].empty)(Monoid[A].combine)

given intAdditionMonoid: Monoid[Int] with
    def empty: Int = 0
    def combine(x: Int, y: Int): Int = x + y

given stringMonoid: Monoid[String] with
    def empty: String = ""
    def combine(x: String, y: String): String = x + y

case class PageMetrics(views: Int, uniqueUsers: Set[String], errors: List[String])

given pageMetricsMonoid: Monoid[PageMetrics] with
    def empty: PageMetrics = PageMetrics(0, Set.empty, List.empty)
    def combine(x: PageMetrics, y: PageMetrics): PageMetrics =
        PageMetrics(
            views = x.views + y.views,
            uniqueUsers = x.uniqueUsers ++ y.uniqueUsers,
            errors = x.errors ++ y.errors
        )

@main def testMonoid(): Unit =
    import Monoid.*

    // Lista vazia não quebra, porque existe `empty`
    println(List.empty[Int].combineAll)        // 0

    val numbers = List(1, 2, 3, 4, 5)
    println(numbers.combineAll)                 // 15

    val logs = List(
        PageMetrics(100, Set("u1", "u2"), List("erro404")),
        PageMetrics(150, Set("u2", "u3"), List("erro500")),
        PageMetrics(50, Set("u1"), List.empty)
    )
    println(logs.combineAll)
    // PageMetrics(300, Set(u1, u2, u3), List(erro404, erro500))
