package compestados.aula


// Mônadas de Estado
case class State[S, A](run: S => (S, A)):
    def map[B](f: A => B): State[S, B] =
        State(s => 
            val (s2, a) = run(s)
            (s2, f(a))
        )

    def flatMap[B](f: A => State[S, B]): State[S, B] =
        State(s =>
            val (s2, a) = run(s)
            f(a).run(s2)   // <- aqui está o "encadeamento" que resolve o Bloco 1
        )
    // O pulo do gato do flatMap: ele pega o novo estado s2 produzido pela primeira computação e já o passa automaticamente para a próxima — sem você precisar desestruturar tupla nenhuma manualmente. É o "state threading" acontecendo escondido dentro da mônada

// com isso, ganhamos a notação for-comprehension
val program: State[Account, Double] =
for
    _   <- deposit(100.0)
    _   <- deposit(50.0)
    bal <- withdraw(30.0)
yield bal

def deposit(amount: Double): State[Account, Unit] =
    State(account => (account.copy(balance = account.balance + amount), ()))

def withdraw(amount: Double): State[Account, Double] =
    State(account =>
        val newBalance = account.balance - amount
        (account.copy(balance = newBalance), newBalance)
    )

// Exemplo prático — concretizar com o contador:
def increment: State[Int, Unit] =
    State(s => (s + 1, ()))

def getValue: State[Int, Int] =
    State(s => (s, s))

val programCounter: State[Int, Int] =
    for
        _     <- increment
        _     <- increment
        _     <- increment
        total <- getValue
    yield total

val (finalState, result) = programCounter.run(0)
// finalState = 3, result = 3

// Nada é mutado — program é só uma descrição da computação. Só quando você chama .run(0) é que a cadeia de transições realmente executa, "passeando" o estado de uma etapa pra próxima
