package laziness.aula

def lazyVal[A](expr: () => A): () => A = {
    var cache: Option[A] = None
    val lock = new AnyRef
    () => lock.synchronized {
        cache match {
        case Some(value) => value
        case None =>
            val value = expr()
            cache = Some(value)
            value
        }
    }
}

@main def mainLazyVal(): Unit =
    ???
