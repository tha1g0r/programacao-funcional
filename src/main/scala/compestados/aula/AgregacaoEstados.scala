package compestados.aula

sealed trait AccountError
case class InsufficientFunds(required: Double, available: Double) extends AccountError

case class Account(balance: Double) {
    def deposit(amount: Double): (Account, Double) =
        (copy(balance = balance + amount), amount)

    def withdraw(amount: Double): (Account, Double) =
        (copy(balance = balance - amount), amount)

    def withdraw2(amount: Double): (Account, Either[InsufficientFunds, Double]) =
        if (amount <= balance)
            (copy(balance = balance - amount), Right(amount))
        else
            (this, Left(InsufficientFunds(amount, balance)))
}

val initialAccount = Account(0.0)

val operations = List[Account => (Account, Double)](
    _.deposit(100.0), _.deposit(50.0), _.withdraw(30.0)
)

val finalAccount = operations.foldLeft(initialAccount) { (acc, op) =>
    val (nextAcc, _) = op(acc)
    nextAcc
}

// exemplo prático: a operação segura interrompe no primeiro erro
val operations2 = List(
    (a: Account) => a.deposit(100.0),
    (a: Account) => a.withdraw2(300.0),  // saldo insuficiente!
    (a: Account) => a.deposit(40.0)
)
// resultado: List(0.0, 100.0, Left(InsufficientFunds(...)), 160.0, ...)
// O saque que falhou vira um Left dentro da lista de histórico, mas o foldLeft continua computando o saldo final como se nada tivesse acontecido — o erro não interrompe a cadeia.
