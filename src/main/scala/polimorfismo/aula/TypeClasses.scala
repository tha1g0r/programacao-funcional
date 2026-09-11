package polimorfismo.aula

import javax.management.Descriptor

trait Area[A]:
    def area(value: A): Double

case class CircleTC(radius: Double)
given Area[CircleTC] with
    def area(c: CircleTC): Double = Math.PI * c.radius * c.radius

extension [A](value: A)
    def area(using a: Area[A]): Double = a.area(value)

// Repare: Circle não estende nada. Dados e comportamento são totalmente desacoplados

trait Serializer[A]:
    def serialize(value: A): String

given serializerList[A](using s: Serializer[A]): Serializer[List[A]] with
    def serialize(value: List[A]): String = value.map(s.serialize).mkString("[", ", ", "]")

@main def mainTypeClasses(): Unit =
    // EXERCÍCIO PRÁTICO

    // 1) CONTRATO: define a interface da type class.
    //    Qualquer tipo A que tiver uma instância de Describable[A]
    //    "sabe" descrever a si mesmo via describe(value).
    trait Describable[A]:
        def describe(value: A): String

    // 2) INSTÂNCIA para Int: implementação ad-hoc do contrato,
    //    específica para o tipo Int. Fica disponível para busca implícita
    //    porque é um `given` de escopo top-level (ou no companion object,
    //    em código de produção).
    given Describable[Int] with
        def describe(n: Int): String = s"Número: $n"

    // Novo tipo de dado — não estende nada, é puro (case class simples),
    // mantendo dados e comportamento desacoplados (o ponto central de type classes).
    case class Book(title: String, pages: Int)

    // 2) INSTÂNCIA para Book: mesmo princípio, agora para um tipo definido por nós.
    given Describable[Book] with
        def describe(b: Book): String = s"${b.title} (${b.pages} páginas)"

    // 2) INSTÂNCIA COMPOSTA para Option[A]: não é uma instância fixa para um tipo
    // concreto, e sim uma "fábrica condicional" de instâncias.
    // A cláusula (using d: Describable[A]) diz ao compilador:
    //   "se você já tem uma evidência de que A é Describable,
    //    eu sei construir uma instância de Describable[Option[A]]."
    // Isso é resolução recursiva de instâncias: o compilador encadeia
    // givens automaticamente (ex: Describable[Option[Int]] é montado
    // a partir de Describable[Int] + describableOption).
    given describableOption[A](using d: Describable[A]): Describable[Option[A]] with
        def describe(v: Option[A]): String = v match
            case None => "Nenhum valor"
            // delega a descrição do valor interno para a instância Describable[A]
            // recebida via using — não sabemos o tipo concreto de A aqui,
            // só sabemos que "existe alguém que sabe descrevê-lo".
            case Some(a) => d.describe(a)

    // 3) INTERFACE DE CONSUMO: método de extensão genérico que expõe
    // a operação da type class com sintaxe de método nativo (value.describe),
    // em vez de chamar a type class diretamente (ex: summon[Describable[A]].describe(value)).
    // O parâmetro `using d: Describable[A]` é preenchido automaticamente
    // pelo compilador, buscando no escopo o given compatível com o tipo de `value`.
    extension [A](value: A)
        def describe(using d: Describable[A]): String = d.describe(value)
