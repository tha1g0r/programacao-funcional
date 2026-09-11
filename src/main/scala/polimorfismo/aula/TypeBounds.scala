package polimorfismo.aula

trait Shape:
    def area: Double

case class Circle(radius: Double) extends Shape:
    def area = math.Pi * radius * radius
    def circumference = 2 * math.Pi * radius

def largest[T <: Shape](a: T, b: T): T = // T deve ser Shape ou subtipo dele
    if a.area > b.area then a else b

val c: Circle = largest(Circle(1.0), Circle(2.0)) // sem asInstanceOf

// ---

trait Pet
case class Dog(name: String) extends Pet
case class Cat(name: String) extends Pet
case class Hamster(name: String) extends Pet

def adoptPair[T >: Dog](a: Dog, b: T): (Dog, T) = (a, b)
//  T deve ser Dog ou supertipo

val r1 = adoptPair(Dog("Rex"), Dog("Max")) // r1 = Tuple(Dog, Dog)
val r2 = adoptPair(Dog("Rex"), Cat("Mimi")) // r2 = Tuple(Dog, Pet)
val r3 = adoptPair(Dog("Rex"), Hamster("Pip")) // r3 = Tuple(Dog, Pet)
// T é inferido como Pet em ambos os casos (r2: (Dog, Pet) e r3: (Dog, Pet)), porque Pet é o menor supertipo comum de Dog e Cat (e de Dog e Hamster) que satisfaz T >: Dog.
