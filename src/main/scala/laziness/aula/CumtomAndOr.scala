package laziness.aula

def customAnd(left: Boolean, right: => Boolean): Boolean =
    if !left then false else right

def customOr(left: Boolean, right: => Boolean): Boolean =
    if left then true else right

def positive(n: Int): Boolean =
    if n >= 0 then true else false

def even(n: Int): Boolean =
    if n % 2 == 0 then true else false

@main def mainCustomAndOr(): Unit =
    println(customOr(positive(4), even(3)))   // right nunca avaliado, "even" nem aparece no log
    println(customOr(positive(-4), even(4)))  // right avaliado, pois left é false
