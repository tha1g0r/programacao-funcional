package tratamentoerros.aula

import scala.util.{Try, Success, Failure}

def parseNumber(s: String): Try[Int] = Try(s.toInt)

def divideStrings(s1: String, s2: String): Try[Int] =
    for
        n1 <- Try(s1.toInt)
        n2 <- Try(s2.toInt)
    yield n1 / n2

@main def mainTry(): Unit =
    println(parseNumber("123")) // Success(123)
    println(parseNumber("abc")) // Failure(NumberFormatException(...))
    
    println(divideStrings("10", "0"))
