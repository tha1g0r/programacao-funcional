package polimorfismo.aula

def sortNormal[A](xs: List[A], ordering: (A, A) => Boolean): List[A] =
    xs.sortWith(ordering)
val sorted = sortNormal(List(1,2,3), (x: Int, y: Int) => x < y)  // repetitivo

def sortUsing[A](xs: List[A])(using ordering: (A, A) => Boolean): List[A] =
    xs.sortWith(ordering)
given ordInt: ((Int, Int) => Boolean) = (x, y) => x < y
val sortedNumbers = sortUsing(List(3, 1, 2))  // ordering injetado automaticamente

case class Product(name: String, price: Double)
given byPrice: Ordering[Product] = Ordering.by(_.price)
def cheapest[A](xs: List[A])(using ord: Ordering[A]): A =
    xs.min(using ord)

@main def mainAbstracaoContexto(): Unit =
    val products = List(Product("A", 10.0), Product("B", 5.0))
    println(cheapest(products))
    println(cheapest(products)(using Ordering.by(_.name))) // muda o ord para considerar name
