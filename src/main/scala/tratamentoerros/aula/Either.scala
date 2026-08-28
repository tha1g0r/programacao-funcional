package tratamentoerros.aula

// Either[E, A] tem dois casos:
// sealed trait Either[+E, +A]
// case class Left[E](value: E) extends Either[E, Nothing]
// case class Right[A](value: A) extends Either[Nothing, A]

def divideE(x: Int, y: Int): Either[String, Int] =
    if y == 0 then Left("Division by zero")
    else Right(x / y)

// A vantagem real aparece quando é usado um tipo de erro estruturado em vez de String:
sealed trait ArithmeticError
case object DivisionByZero extends ArithmeticError
case class NegativeNumberError(value: Int) extends ArithmeticError
case object InvalidMultiply extends ArithmeticError

def dividePositive(x: Int, y: Int): Either[ArithmeticError, Int] =
    if y == 0 then Left(DivisionByZero)
    else if x < 0 || y < 0 then Left(NegativeNumberError(x))
    else Right(x / y)

def calculate(x: Int, y: Int, z: Int): Either[ArithmeticError, Int] =
    def multiply(a: Int, b: Int): Either[ArithmeticError, Int] =
        if (a > Int.MaxValue / b) Left(InvalidMultiply)
        else Right(a * b)

    for
        quotient <- dividePositive(x, y) // quotient é um Int, não um Either
        result <- multiply(quotient, z) // result é um Int, não um Either
    yield result // Int puro entra, mas o for embrulha de volta
    // Resultado final do bloco todo: Either[ArithmeticError, Int]

@main def mainEither(): Unit =
    println(divideE(10, 0))
    println(divideE(10, 2))
    println("-------------------------")

    println(dividePositive(10, 0))
    println(dividePositive(10, 2))
    println("-------------------------")
