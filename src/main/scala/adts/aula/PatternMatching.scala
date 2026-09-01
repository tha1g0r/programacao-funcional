package adts.aula

enum Shape {
    case Circle(radius: Double)
    case Rectangle(width: Double, height: Double)
    case Triangle(base: Double, height: Double)
}

def area(shape: Shape): Option[Double] = shape match
    case Shape.Circle(radius) => Some(Math.PI * radius * radius)
    case Shape.Rectangle(width, height) => Some(width * height)
    case Shape.Triangle(base, height) => Some(0.5 * base * height)

case class Item(n: Double, p: Double)

sealed trait ItemCategory
case class Cheap(item: Item) extends ItemCategory
case class ModeratelyPriced(item: Item) extends ItemCategory
case class Expensive(item: Item) extends ItemCategory
case class Unknown(item: Item) extends ItemCategory

def categorizeItem(item: Item): ItemCategory = item match
    case Item(n, p) if p < 10.0 => Cheap(item)
    case Item(n, p) if p >= 10.0 && p <= 100.0 => ModeratelyPriced(item)
    case Item(n, p) if p > 100.0 => Expensive(item)
    case _ => Unknown(item)

@main def mainPatternMatching(): Unit =
    ???
