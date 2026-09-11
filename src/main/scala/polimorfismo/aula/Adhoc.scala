package polimorfismo.aula

def max(x: Int, y: Int): Int =
    if x > y then x
    else y

def max(x: String, y: String): String =
    if x > y then x
    else y

def plus(x: Int, y: Int): Int = x + y
def plus(x: String, y: String): Int = x.length + y.length()

// def combine[T](x: T, y: T): T = plus(x, y) // o compilador não sabe qual plus usar para um T genérico
