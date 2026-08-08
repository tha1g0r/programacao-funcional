package introducao

@main def ordemSuperior(): Unit =
    def map(xs: List[Int], f: Int => Int): List[Int] =
        // recebe: lista de inteiros e função que recebe int e retorna int
        // retorna: lista de inteiros
        xs.map(f)

    val numbers = List(1, 2, 3, 4, 5)
    val squares = map(numbers, x => x * x)
    val doubles = map(numbers, x => x * 2)

    println(squares) // List(1, 4, 9, 16, 25)
    println(doubles) // List(2, 4, 6, 8, 10)

    enum Operation:
        case Add, Subtract, Multiply, Divide

    def genOperation(op: Operation): (Int, Int) => Int =
        // recebe: Operation
        // retorna: função que recebe dois int e retorna um int
        op match
            case Operation.Add => (a, b) => a + b
            case Operation.Subtract => (a, b) => a - b
            case Operation.Multiply => (a, b) => a * b
            case Operation.Divide => (a, b) => a / b

    val op = genOperation(Operation.Add)
    println(op(10, 5)) // 15

    def applyTwice(f: Int => Int, x: Int): Int = f(f(x))
    println(applyTwice(x => x + 3, 10)) // 16
