package abstracaodedados.aula

trait Stack[T] {
    def push(x: T): Stack[T]
    def pop: (T, Stack[T])
    def isEmpty: Boolean
    def size: Int
}

class ListStack[T] extends Stack[T] {
    override def push(x: T): Stack[T] = ???
    override def pop: (T, Stack[T]) = ???
    override def isEmpty: Boolean = ???
    override def size: Int = ???
}

class ArrayStack[T] extends Stack[T] {
    override def push(x: T): Stack[T] = ???
    override def pop: (T, Stack[T]) = ???
    override def isEmpty: Boolean = ???
    override def size: Int = ???
}

@main def mainTraits(): Unit =
    ???
