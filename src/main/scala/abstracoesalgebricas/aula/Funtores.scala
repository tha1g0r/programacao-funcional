package abstracoesalgebricas.aula

trait Functor[F[_]]:
    def map[A, B](fa: F[A])(f: A => B): F[B]

given listFunction: Functor[List] with
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)

given optionFunctor: Functor[Option] with
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)


// Se você tem h: R => A e quer "mapear" f: A => B por cima, isso é simplesmente composição:
def mapFunction[R, A, B](h: R => A)(f: A => B): R => B =
    h.andThen(f)
    // Isso é chamado de Functor Reader — uma função que "aguarda" uma dependência R para produzir seu valor.

// exemplo boxFunctor
case class Box[A](value: A)

given boxFunctor: Functor[Box] with
    def map[A, B](fa: Box[A])(f: A => B): Box[B] = Box(f(fa.value))
