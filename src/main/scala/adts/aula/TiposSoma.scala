package adts.aula

sealed trait Result[T]
case class Success[T](value: T) extends Result[T]
case class Failure[T](error: String) extends Result[T]

enum ResultEnum[+T] {
    case Success(value: T)
    case Failure(error: String)
    
    // +T é covariância. Ela garante que, por exemplo, None (que estende Option[Nothing]) possa ser usado onde se espera um Option[String] ou Option[Int], porque Nothing é subtipo de todos os tipos
}

enum TrafficLight {
    case Red, Green, Yellow
}

@main def mainTiposSoma(): Unit =
    ???
