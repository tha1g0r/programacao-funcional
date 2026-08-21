package funcoes

// aridade 2
trait Function2[A, B, R] {
    def apply(a: A, b: B): R
}

// aridade 1
trait Function1[A, B] {
    def apply(a: A): B
}
