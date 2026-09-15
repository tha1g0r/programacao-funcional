package compestados.aula

// def withdraw(amount: Double): State[Double, Either[String, Unit]] = ???

// val program: State[Double, Either[String, Double]] = for
//     r1 <- withdraw(30.0)   // State[Double, Either[String, Unit]]
//     result <- r1 match
//         case Left(err) => State.pure(Left(err))         // precisa propagar erro manualmente
//         case Right(_)  => withdraw(50.0).map(_.map(_ => 100.0))  // e aqui de novo...
// yield result

// solução
import cats.data.{State, EitherT}

type Account[A] = EitherT[[X] =>> State[Double, X], String, A]

def withdraw(amount: Double): Account[Unit] =
    EitherT(State { balance =>
        if amount > balance then (balance, Left("Saldo insuficiente"))
        else (balance - amount, Right(()))
    })

def deposit(amount: Double): Account[Unit] =
    EitherT.liftF(State.modify(_ + amount))

val program: Account[Double] = for
    _   <- deposit(100.0)
    _   <- withdraw(200.0)   // se falhar, curto-circuita de verdade aqui
    _   <- deposit(999.0)    // nunca executa se a linha acima falhou
    bal <- EitherT.liftF(State.inspect[Double, Double](identity))
yield bal

val (finalState, result) = program.value.run(0.0).value
// result = Left("Saldo insuficiente"), e o deposit(999.0) NUNCA rodou
