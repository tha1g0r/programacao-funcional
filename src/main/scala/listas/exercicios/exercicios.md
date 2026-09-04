# Exercícios — Capítulo 7: Processamento de Listas

Os exercícios a seguir têm como objetivo colocar em prática os conceitos de
processamento recursivo de listas, recursão de cauda e compartilhamento
estrutural.

Para cada exercício com múltiplos itens, o padrão geral é:
recursão simples → recursão na cauda (`@tailrec`) → implementação com dobras (`fold`).

---

## Exercício 7.1 — `filter`

Escreva uma função recursiva que filtre os elementos de uma lista com base
em um predicado `p`.

- **a)** Escreva uma função recursiva simples (não-cauda) com a assinatura
  `def filter[A](xs: List[A])(p: A => Boolean): List[A]`.
- **b)** Implemente uma versão recursiva na cauda dessa mesma função com a
  assinatura `def filterTail[A](xs: List[A])(p: A => Boolean): List[A]`,
  utilizando parâmetros acumuladores e a anotação `@tailrec`.
- **c)** Projete uma versão simplificada utilizando dobras (folds) com a
  assinatura `def filterFold[A](xs: List[A])(p: A => Boolean): List[A]`.

[Solução 7.1](FilterFunc.scala)

---

## Exercício 7.2 — `map`

Projete uma função recursiva para transformar cada elemento de uma lista
aplicando uma função `f`.

- **a)** Escreva uma versão recursiva simples com a assinatura
  `def map[A, B](xs: List[A])(f: A => B): List[B]`.
- **b)** Projete uma versão recursiva na cauda com a assinatura
  `def mapTail[A, B](xs: List[A])(f: A => B): List[B]`, utilizando o método
  `reverse` no caso base do acumulador.
- **c)** Implemente uma versão baseada em dobras com a assinatura
  `def mapFold[A, B](xs: List[A])(f: A => B): List[B]`.

[Solução 7.2](MapFunc.scala)

---

## Exercício 7.3 — `init`

A função `init` da classe `List` retorna uma nova lista contendo todos os
elementos da lista original, exceto o último. Por exemplo,
`List(1, 2, 3).init` resulta em `List(1, 2)`.

- **a)** Implemente uma função recursiva simples
  `def init[A](xs: List[A]): List[A]`, mas com uma adaptação: ao invés de
  lançar uma exceção `UnsupportedOperationException` se a lista for vazia,
  retorne `Nil`.
- **b)** Explique as complexidades de tempo e espaço dessa operação.
  Justifique se ocorre ou não compartilhamento estrutural com a lista
  original.

[Solução 7.3](InitFunc.scala)

---

## Exercício 7.4 — `take` e `drop`

As operações `take(n)` e `drop(n)` dividem a lista em termos de elementos
mantidos e descartados.

- **a)** Implemente uma função recursiva simples
  `def take[A](xs: List[A], n: Int): List[A]` que retorna os primeiros `n`
  elementos da lista. Se `n ≤ 0` ou a lista for vazia, retorne `Nil`.
- **b)** Implemente uma função recursiva simples
  `def drop[A](xs: List[A], n: Int): List[A]` que retorna a lista restante
  após descartar os primeiros `n` elementos. Se `n ≤ 0` ou a lista for
  vazia, retorne a própria lista.
- **c)** Explique a complexidade de espaço de ambas as operações e discuta
  se ocorre ou não compartilhamento estrutural com a lista original.

[Solução 7.4](TakeDropFuncs.scala)

---

## Exercício 7.5 — `zipWith`

A operação `zipWith` combina os elementos de duas listas par a par
aplicando uma função de combinação.

- **a)** Implemente uma função recursiva simples
  `def zipWith[A, B, C](xs: List[A], ys: List[B])(f: (A, B) => C): List[C]`.
  Se qualquer uma das listas for vazia, retorne `Nil`.
- **b)** Implemente uma versão recursiva na cauda
  `def zipWithTail[A, B, C](xs: List[A], ys: List[B])(f: (A, B) => C): List[C]`,
  utilizando parâmetros acumuladores e a anotação `@tailrec`.

[Solução 7.5](ZipWithFunc.scala)

---

## Exercício 7.6 — `compress`

Escreva uma função que elimine duplicados consecutivos em uma lista de
elementos, mantendo apenas a primeira ocorrência de cada sequência de
valores iguais. Por exemplo, dada a lista `List(1, 1, 2, 2, 3, 1, 1)`, a
função deve retornar `List(1, 2, 3, 1)`.

- **a)** Projete uma função recursiva simples
  `def compress[A](xs: List[A]): List[A]`.
- **b)** Projete uma versão recursiva na cauda
  `def compressTail[A](xs: List[A]): List[A]`.
- **c)** Implemente uma versão baseada em dobras com a assinatura
  `def compressFold[A](xs: List[A]): List[A]`.

[Solução 7.6](CompressFunc.scala)

---

## Exercício 7.7 — `flatten`

A operação `flatten` transforma uma lista de listas em uma lista linear,
concatenando todas as sublistas em ordem. Por exemplo,
`List(List(1, 2), List(3, 4)).flatten` resulta em `List(1, 2, 3, 4)`.

- **a)** Projete uma função recursiva simples
  `def flatten[A](xs: List[List[A]]): List[A]` usando casamento de padrões
  e o operador de concatenação (`:::`).
- **b)** Projete uma versão recursiva na cauda
  `def flattenTail[A](xs: List[List[A]]): List[A]` que execute em tempo
  linear O(n), onde n é o número total de elementos somando todas as
  sublistas, sem realizar alocações extras desnecessárias na recursão.
- **c)** Projete uma versão de única linha utilizando dobras com a
  assinatura `def flattenFold[A](xs: List[List[A]]): List[A]`.
