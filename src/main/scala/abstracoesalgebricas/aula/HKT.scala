package abstracoesalgebricas.aula

// sem HKT, precisa de uma função por F[A]
def doubleList(xs: List[Int]): List[Int] = xs.map(_ * 2)
def doubleOption(xs: Option[Int]): Option[Int] = xs.map(_ * 2)

// com HKT, escrevemos **uma vez**, abstraindo sobre F:
trait Mappeable[F[_]]:
    def map[A, B](fa: F[A])(f: A => B): F[B]

def doubleContext[F[_]](xs: F[Int])(using m: Mappeable[F]): F[Int] =
    m.map(xs)(_ * 2)
// isso já é, essencialmente, a definição de **Functor**

given listMappeable: Mappeable[List] with
    def map[A, B](fa: List[A])(f: A => B): List[B] =
        fa.map(f)

given optionMappeable: Mappeable[Option] with
    def map[A, B](fa: Option[A])(f: A => B): Option[B] =
        fa.map(f)

@main def mainHKT(): Unit =
    val lista = List(1, 2, 3, 4, 5)
    val opt = Option(12)
    println(doubleList(lista))
    println(doubleOption(opt))
    println(doubleContext(lista))
    println(doubleContext(opt))
