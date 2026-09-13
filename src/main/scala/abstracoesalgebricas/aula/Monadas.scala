package abstracoesalgebricas.aula

// O problema: map não basta quando a função já retorna um contexto
val opt: Option[Int] = Some(10)
val f: Int => Option[Int] = x => Some(x / 2)

val mapped: Option[Option[Int]] = opt.map(f)   // Some(Some(5)) — aninhado!
val flattened: Option[Int] = mapped.flatten     // Some(5) — achatado

// flatMap faz as duas coisas de uma vez: map + flatten
val flatMapped: Option[Int] = opt.flatMap(f)    // Some(5)

// Mônada
trait Monad[F[_]] extends Functor[F]:
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    // map "de graça", derivado de pure + flatMap
    override def map[A, B](fa: F[A])(f: A => B): F[B] =
        flatMap(fa)(a => pure(f(a)))
// Isso mostra formalmente que **toda mônada é um funtor** — se você tem pure e flatMap, ganha map de graça

// Exemplo prático: composição de validações sem "pirâmide da perdição"
sealed trait Result[+A]
case class Success[+A](value: A) extends Result[A]
case class Failure(error: String) extends Result[Nothing]

extension [A](result: Result[A])
    def flatMap[B](f: A => Result[B]): Result[B] = result match
        case Success(value) => f(value)
        case Failure(error) => Failure(error)

def addPositive(x: Int, y: Int): Result[Int] =
    if (x > 0 && y > 0) Success(x + y)
    else Failure(s"Operando não positivo ($x, $y)")

val result = addPositive(1, 2)
             .flatMap(addPositive(_, 3))
             .flatMap(addPositive(_, -4))   // curto-circuita aqui
             .flatMap(addPositive(_, 5))
// Failure("Operando não positivo (6, -4)")
// Cada flatMap extrai o valor em caso de sucesso ou propaga a falha automaticamente — sem match aninhado.
