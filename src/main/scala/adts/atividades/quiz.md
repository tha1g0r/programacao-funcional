# Quiz — Tipos de Dados Algébricos

## Questão 1

Sobre a implementação de classes imutáveis em Scala, assinale todas as alternativas corretas:

- [x] a. As propriedades são geralmente declaradas como `val`.
- [ ] b. As propriedades são declaradas como `var`.
- [x] c. Métodos que atualizam o objeto retornam uma nova instância com os valores alterados.
- [ ] d. O uso de objetos imutáveis dificulta a composição de funções.
- [x] e. Objetos imutáveis podem ser compartilhados com segurança entre múltiplas threads.

---

## Questão 2

Sobre o uso de traits em Scala, assinale todas as alternativas corretas:

- [x] a. Traits permitem a definição de métodos abstratos que podem ser reutilizados por várias classes.
- [x] b. Traits podem ser usados para combinar múltiplos comportamentos em uma mesma classe.
- [ ] c. Traits podem ser instanciados diretamente.
- [ ] d. Uma classe pode estender apenas um trait em Scala.
- [x] e. Traits são frequentemente usados para definir interfaces e mixins reutilizáveis.

---

## Questão 3

Sobre o uso de exceções em programação funcional, assinale todas as alternativas corretas:

- [x] a. Exceções devem ser evitadas em programação funcional, pois introduzem efeitos colaterais.
- [x] b. O uso de exceções pode dificultar a composição de funções e o raciocínio sobre o código.
- [ ] c. Exceções são sempre a melhor forma de lidar com erros em programação funcional.
- [ ] d. Exceções são a única forma de tratar erros em programação funcional.
- [x] e. O tratamento de erros deve ser feito de forma explícita, evitando o uso de exceções.

---

## Questão 4

Analise as funções abaixo para assinalar a alternativa correta:

```scala
def f1(a: Int, b: Int): Int = a / b

def f2(a: Int, b: Int): Option[Int] =
  if (b == 0) None else Some(a / b)

def f3(xs: List[Int]): Int = xs.head

def f4(xs: List[Int]): Int = xs.headOption.getOrElse(0)

def f5(x: Int): Int = x * 2
```

Assinale a alternativa correta:

- [x] a. f1 e f3 são funções parciais; f2, f4 e f5 são funções totais.
- [ ] b. f1, f2 e f5 são funções parciais; f3 e f4 são funções totais.
- [ ] c. Apenas f5 é função total; as demais são funções parciais.
- [ ] d. f1 e f3 são funções totais; f2, f4 e f5 são funções parciais.
- [ ] e. Todas as funções são totais.

---

## Questão 5

Sobre o uso do tipo `Option` em Scala para tratamento de erros, assinale todas as alternativas corretas:

- [ ] a. O uso de `Option` obriga o lançamento de exceções sempre que não houver valor.
- [x] b. O padrão `Some(valor)` indica presença de valor, enquanto `None` indica ausência.
- [x] c. `Option` pode ser usada para evitar o uso de valores nulos e representar ausência de valor de forma segura.
- [x] d. O uso de `Option` facilita a composição de funções sem a necessidade de tratar exceções.
- [ ] e. O método `get` de `Option` é seguro e nunca lança exceção.

---

## Questão 6

Considere a função abaixo:

```scala
def dividir(a: Int, b: Int): Option[Int] =
  if (b == 0) None else Some(a / b)
```

Qual das alternativas está correta?

- [x] a. `dividir(10, 2).getOrElse(0)` retorna 5, e `dividir(10, 0).getOrElse(0)` retorna 0.
- [ ] b. `dividir(10, 2)` retorna `None`.
- [ ] c. `dividir(10, 0).get` retorna 0 sem risco de exceção.
- [ ] d. `dividir(10, 0)` sempre lança uma exceção.
- [ ] e. O uso de `Option` absorve a exceção sem notificá-la, prejudicando a composição funcional.

---

## Questão 7

Qual é a principal vantagem de utilizar o tipo `Either` em vez de `Option` para tratamento de erros em Scala?

- [ ] a. `Option` só pode ser usado para valores numéricos, enquanto `Either` pode ser usado com qualquer tipo.
- [ ] b. `Either` lança exceção automaticamente ao encontrar um erro.
- [ ] c. `Either` permite indicar apenas falhas, não sucessos.
- [ ] d. `Option` é menos seguro que `Either` em termos de composição funcional.
- [x] e. `Either` permite indicar não apenas a ausência de valor, mas também a natureza do erro.

---

## Questão 8

Qual é a principal diferença entre tipos abstratos e tipos algébricos?

- [ ] a. Não há diferença significativa entre eles.
- [ ] b. Tipos abstratos são mais complexos que tipos algébricos.
- [ ] c. Tipos abstratos são imutáveis, tipos algébricos são mutáveis.
- [ ] d. Tipos algébricos só podem ser usados em programação funcional e tipos abstratos somente em orientação a objetos.
- [x] e. Tipos abstratos especificam comportamento, tipos algébricos especificam estrutura.

---

## Questão 9

Quais são as características dos tipos de dados algébricos? Selecione todas as corretas.

- [x] a. Incluem tipos soma e tipos produto.
- [ ] b. São exclusivos de linguagens funcionais.
- [ ] c. Não permitem misturar tipos produto e tipos soma.
- [x] d. Permitem modelar dados complexos de forma segura.
- [x] e. São definidos em termos da cardinalidade do domínio dos tipos envolvidos.

---

## Questão 10

Em Scala, qual método é gerado automaticamente pelo compilador para permitir a criação de novas instâncias de `case class` com alguns componentes modificados?

- [ ] a. `apply`
- [ ] b. `clone`
- [ ] c. `update`
- [x] d. `copy`
- [ ] e. `transform`

---

## Questão 11

Quais das seguintes estruturas **NÃO** são consideradas tipos produto válidos?

- [ ] a. Uma tupla `(Int, String, Boolean)`.
- [x] b. Uma `List[Int]` contendo os valores 1, 2 e 3.
- [ ] c. Uma `case class Person(name: String, age: Int)`.
- [x] d. Um `Vector[Int]`.
- [ ] e. Uma tupla `(Double, Double)` representando coordenadas.

> List e Vector não têm número fixo de componentes

---

## Questão 12

Qual é a diferença fundamental entre tuplas e `case classes` como representação de tipos produto?

- [ ] a. Tuplas permitem herança, enquanto `case classes` apenas implementam traits.
- [ ] b. Tuplas são mutáveis, `case classes` são imutáveis.
- [x] c. `Case classes` oferecem recursos mais poderosos para manipulação de dados.
- [ ] d. Não há diferença no poder de expressividade e de funcionalidade entre as duas representações.
- [ ] e. Tuplas são mais simples e mais eficientes.

---

## Questão 13

Qual é a principal diferença entre polimorfismo de subtipos e tipos soma?

- [x] a. Polimorfismo define hierarquia aberta, tipos soma definem hierarquia fechada.
- [ ] b. Polimorfismo só funciona em linguagens orientadas a objetos.
- [ ] c. Não há diferença.
- [ ] d. Tipos soma são mais eficientes.
- [ ] e. Tipos soma não permitem herança.

> Polimorfismo permite extensão em qualquer lugar, tipos soma têm conjunto fixo de variantes

---

## Questão 14

Qual é o padrão de projeto recomendado para criar tipos soma em Scala? Selecione todas as corretas.

- [x] a. Usar `case class` para tipos que armazenam dados.
- [x] b. Usar `case object` para tipos sem dados (singleton).
- [ ] c. Permitir extensão do `trait` em outros arquivos.
- [x] d. Definir um `sealed trait` como base.
- [ ] e. Usar `abstract class` em vez de `sealed trait`.

---

## Questão 15

Considere a definição de uma lista como tipo algébrico:

```scala
sealed trait MyList[+A]

case object MyNil extends MyList[Nothing]

case class MyCons[A](head: A, tail: MyList[A])
  extends MyList[A]
```

Quais afirmações são corretas? Selecione todas as corretas.

- [ ] a. `MyCons` é um tipo soma.
- [ ] b. `MyList` é um tipo produto.
- [x] c. A estrutura de dados possui uma definição recursiva.
- [x] d. `MyNil` é um singleton.
- [x] e. A definição permite listas vazias.

---

## Questão 16

Considere a seguinte definição de um tipo produto e seu método `unapply` em Scala:

```scala
case class Person(name: String, age: Int)

object Person {
  def unapply(p: Person): Option[(String, Int)] =
    Some((p.name, p.age))
}
```

Qual das alternativas abaixo representa uma destruturação válida usando pattern matching para esse tipo?

- [ ] a. `case (n, a) => println(n + a)`
- [ ] b. `case Person => println("Pessoa")`
- [x] c. `case Person(n, a) => println(s"$n tem $a anos")`
- [ ] d. `case Person(name) => println(name)`
- [ ] e. `case Person(n, a, x) => println(n)`

---

## Questão 17

Considere o seguinte código Scala, que utiliza pattern matching para extrair informações de uma forma geométrica:

```scala
sealed trait Shape

case class Circle(radius: Double) extends Shape

case class Rectangle(width: Double, height: Double)
  extends Shape

val s: Shape = Circle(5.0)

s match {
  case Circle(r) =>
    println(s"raio = $r")

  case Rectangle(w, h) =>
    println(s"largura = $w, altura = $h")
}
```

Considere as seguintes definições para o companion object de `Circle`:

**H)**

```scala
object Circle {
  def apply(radius: Double): Circle =
    new Circle(radius)
}
```

**I)**

```scala
object Circle {
  def unapply(c: Circle): Option[Double] =
    Some(c.radius)
}
```

**J)**

```scala
object Circle {
  def toString: String = "Circle"
}
```

**K)**

```scala
object Circle {
  def equals(c: Any): Boolean = false
}
```

**L)**

```scala
object Circle {
  def copy(c: Circle): Circle = c
}
```

Para que o *pattern matching acima funcione* para `Circle`, qual das opções (H–L) implementa corretamente o companion object?

- [ ] a. K
- [ ] b. H
- [ ] c. L
- [x] d. I
- [ ] e. J

---

## Questão 18

Considere o seguinte código Scala:

```scala
sealed trait X

case object A extends X
case object B extends X
case object C extends X

def f(x: X): String = x match {
  case A => "a"
  case B => "b"
  case _ => "?"
  case C => "c"
}

val result = f(A) + f(B) + f(C)
```

Qual será o valor de `result`?

- [ ] a. `"a?c"`
- [ ] b. `"a?"`
- [ ] c. `"abc"`
- [ ] d. `"?b?"`
- [x] e. `"ab?"`

> A expressão `match` compara um valor contra vários padrões e executa o código do primeiro que corresponder

---

## Questão 19

Considere o seguinte código Scala:

```scala
sealed trait Expr

case class Num(value: Int) extends Expr

case class Add(left: Expr, right: Expr)
  extends Expr

def eval(e: Expr): Int = e match {
  case Num(v) => v
  case Add(l, r) => eval(l) + eval(r)
}
```

Agora, suponha que adicionamos um novo tipo produto:

```scala
case class Mul(left: Expr, right: Expr)
  extends Expr
```

O que acontece se não atualizarmos a expressão `match` na função `eval` para tratar `Mul`?

- [ ] a. Ocorre erro em tempo de execução.
- [ ] b. O programa não compila.
- [ ] c. O código compila mas gera exceção de `ClassCastException`.
- [x] d. O compilador emite um aviso sobre exaustividade.
- [ ] e. O código funciona normalmente.

---

## Questão 20

Quais são as principais vantagens dos tipos algébricos? Selecione todas as corretas.

- [x] a. Testagem exaustiva de tipos é garantida pelo compilador.
- [x] b. Eliminação de erros com valores nulos.
> `Option[T]` força o tratamento explícito da ausência de valores
- [x] c. Segurança de tipos aprimorada.
> Mais verificações em tempo de compilação significam menos erros em runtime
- [ ] d. Melhor performance de execução.
- [ ] e. Dificultam a refatoração.
