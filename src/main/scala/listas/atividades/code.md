# Atividade 6.2 - Conjuntos ordenados (Listas)

## Objetivos

- Compreender e aplicar o conceito de complexidade algorítmica sobre listas encadeadas imutáveis.
- Entender como parametrizar funções puras encapsulando o comportamento de ordenação em uma classe de operações.
- Praticar casamento de padrões recursivo com múltiplos escopos simultâneos (tuplas de listas).
- Analisar o compartilhamento estrutural de células `cons` na memória sob a ótica de estruturas de dados persistentes.

## Orientações

Antes de iniciar a atividade, consulte o documento “Instruções gerais para atividades de programação”, disponível no Moodle. Ele contém informações importantes sobre onde encontrar o seu repositório, o uso do GitHub e outras orientações gerais.

## Código prévio

A atividade está concentrada no seguinte arquivo:

```text
OrderedSet.scala
```

## Introdução

Uma estrutura de dados de conjunto (*Set*) armazena elementos únicos. Se implementarmos um conjunto usando uma lista encadeada imutável desordenada (`List[A]`), verificar se um elemento existe ou inserir um novo elemento exige varrer a lista inteira, resultando em custo linear `O(N)`. Consequentemente, operações como união, intersecção e diferença de conjuntos acabam tendo custo quadrático `O(N × M)`, pois, para cada elemento do primeiro conjunto, precisamos varrer o segundo.

Nesta atividade, implementaremos a estrutura de dados `OrderedSet` utilizando uma lista encadeada (`List[A]`) ordenada de forma crescente e sem elementos duplicados como representação interna direta. Essa restrição de ordenação nos permite realizar as operações de união, intersecção e diferença em tempo linear estrito `O(N + M)`, usando um algoritmo de mesclagem por dois ponteiros de forma puramente recursiva.

## Modelo de dados

Para parametrizar a ordenação do conjunto de maneira simples e funcional, definiremos uma classe de operações `OrderedSet[A]` inicializada com uma função de comparação `comp: (A, A) => Int`. Dessa forma, podemos definir como ordenar qualquer tipo de elemento que venha concretizar o tipo genérico `A`. As operações de conjunto receberão e retornarão listas puras (`List[A]`), operando diretamente na estrutura nativa de listas de Scala.

```scala
package orderedSet

class OrderedSet[A](val comp: (A, A) => Int) {
  def insert(set: List[A], elem: A): List[A] = ???
  def union(set1: List[A], set2: List[A]): List[A] = ???
  def intersect(set1: List[A], set2: List[A]): List[A] = ???
  def difference(set1: List[A], set2: List[A]): List[A] = ???
}
```

Exemplo de uso:

```scala
val setOp = new OrderedSet[Int]((x, y) => x.compare(y))
val s1 = List(1, 3, 5)
val s2 = List(2, 3, 6)

setOp.insert(s1, 4)      // Resultado: List(1, 3, 4, 5)
setOp.union(s1, s2)       // Resultado: List(1, 2, 3, 5, 6)
setOp.intersect(s1, s2)   // Resultado: List(3)
setOp.difference(s1, s2)  // Resultado: List(1, 5)
```

A função de comparação `comp(x, y)` retorna:

- Um valor negativo se `x < y`.
- Zero se `x == y`.
- Um valor positivo se `x > y`.

## O que fazer

Implemente todas as operações da classe `OrderedSet`, de acordo com as especificações a seguir.

### Inserção ordenada

Implemente o método:

```scala
def insert(set: List[A], elem: A): List[A]
```

Insira o elemento `elem` na lista `set`, mantendo a ordenação crescente. Se o elemento já existir no conjunto, a lista original deve ser retornada inalterada, mantendo o compartilhamento da mesma instância de lista. Esta função deve executar em tempo `O(N)`.

### União de conjuntos

Implemente o método:

```scala
def union(set1: List[A], set2: List[A]): List[A]
```

Realize a união de duas listas ordenadas em tempo `O(N + M)`.

### Intersecção de conjuntos

Implemente o método:

```scala
def intersect(set1: List[A], set2: List[A]): List[A]
```

A intersecção retorna os elementos que pertencem a ambos os conjuntos. O algoritmo deve garantir complexidade de tempo de execução estrita `O(N + M)`.

### Diferença de conjuntos

Implemente o método:

```scala
def difference(set1: List[A], set2: List[A]): List[A]
```

Informe os elementos que pertencem a `set1`, mas não a `set2`. O algoritmo deve garantir complexidade de tempo de execução estrita `O(N + M)`.

## Restrições

As operações devem ser implementadas usando recursão e casamento de padrões, respeitando a complexidade de tempo linear.
