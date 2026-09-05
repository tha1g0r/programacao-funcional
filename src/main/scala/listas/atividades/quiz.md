# Atividade 6.1 — Listas

## Questão 1

Considere o seguinte algoritmo:

```scala
def f1[T](l1: List[T]): List[T] = {
  def f2(a: List[T], b: List[T]): List[T] = {
    if (a.isEmpty) b
    else f2(a.tail, a.head :: b)
  }

  f2(l1, Nil)
}
```

O que faz o algoritmo `f1`?

- [x] a. Ele inverte a lista `l1` e retorna a nova lista.
- [ ] b. Ele faz uma cópia da lista original.
- [ ] c. Ele concatena as duas listas `a` e `b`.
- [ ] d. Ele inverte a lista `l1` e adiciona um elemento ao final.
- [ ] e. Ele remove elementos duplicados da lista.

---

## Questão 2

Considere a operação de concatenação de listas imutáveis em Scala:

```scala
def concatenate[A](xs: List[A], ys: List[A]): List[A] = {
  def loop(rs: List[A], zs: List[A]): List[A] = {
    if (rs.isEmpty) zs
    else loop(rs.tail, rs.head :: zs)
  }

  loop(xs.reverse, ys)
}
```

Assinale todas as alternativas corretas:

- [x] a. Apenas `xs` é duplicada na memória, enquanto `ys` é estruturalmente compartilhada.
- [ ] b. A operação tem complexidade de tempo `O(n × k)`, onde `n` é o comprimento da lista `xs` e `k` é o comprimento da lista `ys`.
- [ ] c. A operação tem complexidade de espaço `O(n × k)`, onde `n` é o comprimento da lista `xs` e `k` é o comprimento da lista `ys`.
- [ ] d. Se `xs` for muito grande, a operação pode levar a estouro de pilha devido à recursão.
- [x] e. A operação utiliza recursão na cauda, o que permite otimização pelo compilador.

---

## Questão 3

Considere o código Scala abaixo:

```scala
case class Ponto(x: Double, y: Double)

val pontos = List(
  Ponto(1.0, 4.0),
  Ponto(3.0, 2.0),
  Ponto(2.0, 5.0)
)

val r1 = pontos.sortBy(_.y) // P(3, 2), P(1, 4), P(2, 5)
val r2 = pontos.sortWith((p1, p2) => p1.x > p2.x) // P(3, 2), P(2, 5), P(1, 4)
```

Quais serão os valores das cabeças (`head`) das listas `r1` e `r2` após a execução?

- [ ] a. `r1.head = Ponto(3.0, 2.0)` e `r2.head = Ponto(2.0, 5.0)`
- [x] b. `r1.head = Ponto(3.0, 2.0)` e `r2.head = Ponto(3.0, 2.0)`
- [ ] c. `r1.head = Ponto(2.0, 5.0)` e `r2.head = Ponto(3.0, 2.0)`
- [ ] d. `r1.head = Ponto(1.0, 4.0)` e `r2.head = Ponto(3.0, 2.0)`
- [ ] e. `r1.head = Ponto(1.0, 4.0)` e `r2.head = Ponto(1.0, 4.0)`

---

## Questão 4

Considere o algoritmo puramente funcional de *selection sort* implementado sobre listas imutáveis:

```scala
def selectionSort(xs: List[Int]): List[Int] = {
  def findMin(ys: List[Int]): Option[Int] = ys match {
    case Nil => None
    case head :: tail =>
      findMin(tail) match {
        case None    => Some(head)
        case Some(m) => Some(if (head < m) head else m)
      }
  }

  def removeOne(ys: List[Int], x: Int): List[Int] =
    ys match {
      case Nil => Nil
      case head :: tail =>
        if (head == x) tail
        else head :: removeOne(tail, x)
    }

  xs match {
    case Nil => Nil
    case _ =>
      val min = findMin(xs).get
      min :: selectionSort(removeOne(xs, min))
  }
}
```

Assinale todas as alternativas corretas sobre a complexidade e o comportamento desse algoritmo:

- [x] a. A complexidade de tempo do algoritmo é `O(n²)`, onde `n` é o tamanho da lista original.
- [x] b. Para cada elemento ordenado e inserido na lista final, a função `removeOne` pode reconstruir até `O(n)` nós na memória.
- [ ] c. O algoritmo utiliza extensivamente compartilhamento estrutural, evitando qualquer alocação de novos nós na memória ao remover o menor elemento.
- [x] d. A complexidade de espaço auxiliar na pilha de execução é `O(n)`, pois as funções internas e a recursão principal não são otimizadas para recursão na cauda.
- [ ] e. A complexidade de tempo seria otimizada para `O(n log n)` se usássemos busca binária em `findMin`.

---

## Questão 5

Considere o código Scala a seguir que manipula listas imutáveis:

```scala
val l1 = List(1, 2)
val l2 = List(3, 4)

val r1 = 0 :: l1 ::: l2
val r2 = (l1 ++ l2).foldLeft(10)(_ - _)
```

Quais são os valores finais de `r1` e `r2` após a execução?

- [ ] a. `r1 = List(0, 1, 2, 3, 4)` e `r2 = 4`
- [ ] b. `r1 = List(1, 2, 3, 4, 0)` e `r2 = 0`
- [ ] c. `r1 = List(0, 1, 2, List(3, 4))` e `r2 = 4`
- [ ] d. `r1 = List(0, 1, 2, 3, 4)` e `r2 = -10`
- [x] e. `r1 = List(0, 1, 2, 3, 4)` e `r2 = 0`

---

## Questão 6

Considere o código Scala abaixo:

```scala
val xs = List(1, 2, 3)
val ys = xs :+ 4
```

O que ocorre com as listas `xs` e `ys` após a execução?

- [ ] a. Ambas as listas compartilham todos os nós, inclusive o novo elemento.
- [ ] b. O elemento `4` é inserido no início de `xs`.
- [ ] c. `xs` é modificada para conter o elemento `4`.
- [ ] d. `xs` sofre uma mutação para incluir o elemento `4`, em seguida `ys` recebe uma referência a `xs`.
- [x] e. `ys` é uma nova lista contendo os elementos de `xs` mais o `4`, e `xs` permanece inalterada.

---

## Questão 7

A respeito da soma dos elementos de uma lista usando dobras em Scala (`foldLeft` e `foldRight`), assinale todas as alternativas corretas:

- [x] a. A expressão `xs.foldLeft(0)(_ + _)` é equivalente a `xs.foldRight(0)(_ + _)` em termos de resultado, pois a adição é uma operação associativa e comutativa.
- [x] b. O uso de dobras (*folds*) elimina a necessidade de definir explicitamente o passo recursivo e o caso base no código do usuário.
- [ ] c. O método `foldRight` processa a lista da direita para a esquerda e é inerentemente recursivo na cauda, não consumindo espaço na pilha de execução.
- [x] d. A complexidade de tempo de ambos os métodos ao somar uma lista de tamanho `n` é `O(n)`.
- [x] e. O método `foldLeft` é implementado utilizando recursão na cauda, garantindo segurança contra estouro de pilha para listas muito grandes.

> `foldLeft` é recursivo na cauda, já `foldRight`, não

---

## Questão 8

Sobre o algoritmo para determinar o comprimento de uma lista, reproduzido abaixo, assinale todas as alternativas corretas:

```scala
def comprimento(xs: List[Int]): Int =
  if (xs.isEmpty) 0
  else 1 + comprimento(xs.tail)
```

- [x] a. A complexidade de tempo da função é `O(n)`, onde `n` é o comprimento da lista.
- [ ] b. A função pode ser otimizada para `O(log n)` usando técnicas de memoização.
- [ ] c. A função utiliza mutabilidade para armazenar o comprimento.
- [ ] d. A complexidade de espaço é `O(1)`, pois não é necessário garantir persistência.
> recursividade simples, não cauda
- [x] e. A função percorre toda a lista, visitando cada elemento uma vez.

---

## Questão 9

Considere a seguinte função recursiva para calcular o comprimento de uma lista em Scala:

```scala
def comprimento(xs: List[Int], acc: Int = 0): Int =
  if (xs.isEmpty) acc
  else comprimento(xs.tail, acc + 1)
```

Assinale todas as alternativas corretas:

- [x] a. A complexidade de tempo da função é `O(n)`, onde `n` é o comprimento da lista.
- [ ] b. A função pode ser otimizada para `O(log n)` usando técnicas de memoização.
- [ ] c. A função usa espaço `O(n)`.
- [ ] d. A complexidade de espaço é `O(n)`, pois é necessário duplicar a lista devido à persistência.
- [x] e. A função utiliza recursão na cauda.

---

## Questão 10

Considere o seguinte algoritmo iterativo para somar os elementos de uma lista de inteiros em Scala:

```scala
def somaIterativa(xs: List[Int]): Int = {
  var soma = 0

  for (x <- xs) {
    soma += x
  }

  soma
}
```

Considere ainda as seguintes tentativas de convertê-lo para uma versão recursiva:

### Implementação F

```scala
def somaRecursiva(xs: List[Int]): Int =
  if (xs.isEmpty) 0
  else xs.head + somaRecursiva(xs.tail)
```

### Implementação G

```scala
def somaRecursiva(xs: List[Int], acc: Int = 0): Int =
  if (xs.isEmpty) acc
  else somaRecursiva(xs.tail, acc + xs.head)
```

### Implementação H

```scala
def somaRecursiva(xs: List[Int], acc: Int = 0): Int = {
  if (xs.isEmpty) acc
  else somaRecursiva(xs.tail, xs.tail.sum)
}
```

Qual das alternativas inclui uma adaptação correta **e** recursiva na cauda para o algoritmo iterativo?

- [ ] a. Implementação H
- [ ] b. Implementação F
- [x] c. Implementação G
- [ ] d. Implementação F e Implementação G
- [ ] e. Implementação F e Implementação H

---

## Questão 11

Considere o algoritmo em Scala:

```scala
def f[A](xs: List[A], a: A): List[A] = {
  if (xs.isEmpty) List(a)
  else xs.head :: f(xs.tail, a)
}
```

Para a chamada:

```scala
f(List(1, 2, 3), 4)
```

qual é o resultado?

- [ ] a. `List(1, 2, 3, 4, 4)`
- [ ] b. `List(4, 1, 2, 3)`
- [ ] c. `List(4)`
- [x] d. `List(1, 2, 3, 4)`
- [ ] e. `List(4, 1, 2, 3, 4)`

---

## Questão 12

Considere a seguinte função:

```scala
def foo[A](xs: List[A], elem: A): List[A] = {
  @scala.annotation.tailrec
  def bar(xs: List[A], zhe: List[A]): List[A] = {
    if (xs.isEmpty) (elem :: zhe).reverse
    else bar(xs.tail, xs.head :: zhe)
  }

  bar(xs, Nil)
}
```

O que a função `foo` faz?

- [ ] a. Ela retorna uma lista vazia se `xs` estiver vazia.
- [ ] b. Ela adiciona o elemento `elem` ao início da lista `xs`.
- [ ] c. Ela remove o elemento `elem` da lista `xs`.
- [ ] d. Ela inverte a lista `xs` e adiciona `elem` ao início.
- [x] e. Ela adiciona o elemento `elem` ao final da lista `xs`.

---

## Questão 13

Considere o algoritmo para adicionar um elemento ao final de uma lista imutável em Scala:

```scala
def append[A](xs: List[A], elem: A): List[A] = {
  if (xs.isEmpty) List(elem)
  else xs.head :: append(xs.tail, elem)
}
```

Selecione apenas as alternativas corretas:

- [ ] a. O algoritmo não cria uma nova lista, mas modifica a lista original.
- [x] b. O algoritmo tem complexidade de tempo `O(n)`, onde `n` é o comprimento da lista.
- [ ] c. O algoritmo é eficiente, pois utiliza recursão na cauda.
- [ ] d. O algoritmo tem complexidade de espaço `O(1)`.
- [x] e. O algoritmo não utiliza compartilhamento estrutural, pois cada chamada recursiva cria um novo nó.

> Toda vez que você escreve `xs.head :: append(xs.tail, elem)`, o Scala aloca um nó novo na memória — mesmo que `xs.head` seja "o mesmo valor" que já existia na lista original. `::` sempre cria uma célula nova; ele nunca reaproveita a célula da lista de entrada, porque a célula da lista de entrada tem seu próprio campo tail apontando para o resto da lista antiga — e você não pode mudar esse campo (imutabilidade), então não dá pra "reciclar" esse nó com um tail diferente

---

## Questão 14

Considere o seguinte algoritmo em Scala:

```scala
def f[A](xs: List[A]): List[A] = {
  if (xs.isEmpty) Nil
  else f(xs.tail) :+ xs.head
}
```

Assinale todas as alternativas corretas:

- [ ] a. O algoritmo utiliza recursão na cauda, o que permite otimização pelo compilador.
- [ ] b. O algoritmo tem complexidade de tempo `O(n)`, onde `n` é o comprimento da lista.
- [x] c. O algoritmo tem complexidade de espaço `O(n)`, onde `n` é o comprimento da lista.
- [ ] d. O algoritmo tem complexidade de espaço `O(n²)`, pois cada chamada recursiva cria uma nova lista do zero.
- [x] e. O algoritmo tem complexidade de tempo `O(n²)`, onde `n` é o comprimento da lista.

---

## Questão 15

Sobre a classe `List` imutável em Scala, assinale todas as alternativas corretas:

- [x] a. O método `head` retorna o primeiro elemento da lista, em tempo `O(1)`.
- [ ] b. O método `length` tem tempo `O(1)`, pois apenas acessa o tamanho armazenado da lista.
- [ ] c. Adicionar um elemento no final da lista (`:+`) é uma operação de tempo constante.
- [ ] d. O método `tail` retorna o último elemento da lista, em tempo `O(n)`.
- [x] e. Adicionar um elemento no início da lista (`::`) é uma operação eficiente, de tempo `O(1)`.

---

## Questão 16

Sobre a hierarquia de tipos da classe `List` em Scala, assinale todas as alternativas corretas:

- [x] a. O objeto `Nil` estende `List[Nothing]`, o que permite que ele seja usado como uma lista de qualquer tipo devido à covariância de `List[+A]`.
- [ ] b. A classe `List` é invariante em seu parâmetro de tipo `A`, de modo que um `List[Int]` não pode ser atribuído a um `List[Any]`.
- [x] c. A classe concreta `::` (`Cons`) é um `case class` que armazena a cabeça (`head`) e a cauda (`tail`) da lista.
- [ ] d. Chamar o método `head` ou `tail` diretamente no objeto `Nil` retorna um valor padrão ou uma lista vazia, respectivamente, sem lançar exceções.
- [x] e. A classe `List` é abstrata e selada (`sealed`), impossibilitando extensões arbitrárias fora de seu arquivo de definição.

---

## Questão 17

A recursão estrutural difere da recursão generativa em vários aspectos fundamentais.

Qual das seguintes alternativas apresenta uma característica exclusiva da recursão estrutural?

- [x] a. Os subproblemas processados em cada chamada recursiva são extraídos diretamente dos subcomponentes imediatos da estrutura de entrada.
- [ ] b. A prova de terminação do algoritmo é complexa e exige demonstrar que um valor de controle diminui com base em uma métrica gerada dinamicamente.
- [ ] c. Ela processa os dados de trás para frente usando obrigatoriamente recursão em cauda.
- [ ] d. Ela é exemplificada por algoritmos como o Quicksort, onde subvetores são gerados a partir de partições dinâmicas.
- [ ] e. Ela exige o uso de variáveis mutáveis para acumular o resultado ao longo das chamadas recursivas.

---

## Questão 18

Sobre a garantia de terminação e percurso na recursão estrutural aplicada a listas encadeadas finitas, assinale todas as alternativas corretas:

- [x] a. Ao contrário da recursão generativa, a recursão estrutural não requer uma função de controle complexa para provar que o loop recursivo irá parar.
- [x] b. A terminação é garantida naturalmente se a estrutura de dados de entrada for finita, pois cada chamada consome uma cauda (`tail`) que é estritamente menor.
- [ ] c. Se a lista de entrada for infinita, como um fluxo preguiçoso infinito, a recursão estrutural avaliada de forma estrita de todas as formas terminará com sucesso.
- [x] d. O caso base da recursão estrutural em listas corresponde obrigatoriamente à verificação da lista vazia (`Nil` ou `isEmpty`).
- [ ] e. A recursão estrutural depende de gerar novos dados que não existiam na entrada para decidir quando parar.

---

## Questão 19

Considere as operações de inserção em listas imutáveis em Scala.

Por que a operação de adicionar um elemento no início (`::`) aproveita o compartilhamento estrutural, enquanto a de adicionar no final (`:+`) não?

- [ ] a. Porque listas imutáveis são implementadas como árvores binárias de busca, onde a inserção à esquerda é mais rápida.
- [ ] b. Porque a operação de `append` duplica apenas o último elemento da lista, enquanto `cons` copia toda a lista na memória.
- [x] c. Porque o operador `cons` (`::`) aloca apenas um novo nó apontando para a lista original existente, enquanto o `append` (`:+`) exige duplicar todos os nós da lista original para ajustar o ponteiro do último elemento.
- [ ] d. Porque o operador `::` altera diretamente a propriedade mutável `tail` do objeto original, enquanto o `:+` lança uma exceção.
- [ ] e. Porque a recursão na cauda impede o compartilhamento de dados em qualquer operação de inserção.

---

## Questão 20

Em relação ao compartilhamento estrutural em listas imutáveis, assinale todas as alternativas corretas sobre sua segurança e implicações de memória:

- [ ] a. Chamar o método `tail` em uma lista exige a cópia profunda de todos os elementos restantes.
- [x] b. Operações como concatenar duas listas com `xs ++ ys` compartilham estruturalmente a lista da direita (`ys`), copiando apenas a lista da esquerda (`xs`).
- [x] c. O compartilhamento estrutural reduz drasticamente o consumo de memória ao permitir que múltiplas listas compartilhem referências para caudas comuns.
- [x] d. O compartilhamento estrutural é completamente seguro porque as listas são imutáveis; não há risco de uma alteração em uma lista afetar outras listas que compartilham a mesma cauda.
- [ ] e. Modificar um elemento no meio de uma lista imutável pode ser feito em tempo `O(1)` sem quebrar o compartilhamento estrutural.
