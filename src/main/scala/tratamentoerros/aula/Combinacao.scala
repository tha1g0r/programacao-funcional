package tratamentoerros.aula

import scala.util.Try

def readFile(path: String): Try[String] =
    Try(scala.io.Source.fromFile(path).mkString)

def validateField(content: String, field: String): Either[String, String] =
    if (content.contains(field)) Right(content)
    else Left(s"Campo obrigatório ausente: $field")

def loadConfig(path: String, requiredField: String): Either[String, String] =
    for {
        content   <- readFile(path).toEither.left.map(_.getMessage) // Try -> Either
        validated <- validateField(content, requiredField)          // já é Either
    } yield validated

@main def mainCombinacao(): Unit =
    ???
