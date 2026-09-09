package laziness.aula

def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else if (n == 2) true
    else if (n % 2 == 0) false
    else (3 to math.sqrt(n).toInt by 2).forall(n % _ != 0)
}

def rangeLazy(start: Int, end: Int): LazyList[Int] =
    if (start > end) LazyList.empty
    else start #:: rangeLazy(start + 1, end)

@main def mainListaPreguicosa(): Unit =
    println(rangeLazy(1, 10).filter(isPrime).take(3).toList)
    // Numa List ansiosa, isso geraria os 10 números, testaria os 10 com isPrime, e só depois pegaria 3. Com LazyList, o pipeline gera e testa 1, para; gera e testa 2, para; ... até achar 3 primos — parando assim que take(3) for satisfeito.
