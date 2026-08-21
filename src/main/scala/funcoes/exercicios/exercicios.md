# Capítulo 3 — Exercícios (3.11)

> Os exercícios a seguir devem ser necessariamente resolvidos por meio da utilização das funções de ordem superior: `map`, `filter`, `reduce`, `fold`, etc. Não utilizar recursão explícita ou estruturas de controle imperativas (como `for`, `while`, etc.). O objetivo é praticar a composição de funções e o uso de combinadores de coleção para resolver problemas comuns de manipulação de dados.
>
> **Nota geral:** para acessar os elementos de uma tupla, utilize a notação `x._1` para o primeiro elemento, `x._2` para o segundo elemento, e assim por diante, considerando que `x` é a tupla.

---

## Exercício 3.1

Defina uma função que receba uma lista de números inteiros e produza outra lista, contendo apenas os números ímpares dobrados. Por exemplo, dada a lista `List(1, 2, 3, 4, 5)`, a função deve produzir `List(2, 6, 10)`.

[Código](ImparesDobrados.scala)

---

## Exercício 3.2

Defina uma função que receba uma lista de strings, e dois inteiros, um contendo um limite inferior e outro contendo um limite superior. A função deve produzir outra lista contendo apenas as strings cujo tamanho esteja entre os limites especificados. Por exemplo, dada a lista `List("Scala", "Java", "Python", "C++")`, com limites 3 e 5, a função deve produzir `List("Scala", "Java", "C++")`.

[Código](StringLimitada.scala)

---

## Exercício 3.3

Defina uma função que receba uma lista de números inteiros e produza a soma dos quadrados dos números pares. Por exemplo, dada a lista `List(1, 2, 3, 4, 5)`, a função deve produzir 20 (pois $2^2 + 4^2 = 4 + 16 = 20$).

[Código](ParesQuadradosSomados.scala)

---

## Exercício 3.4

As notas dos estudantes de uma turma são representadas por uma lista de tuplas, onde cada tupla contém o nome do estudante e sua nota. Por exemplo:

```scala
List(
  ("Alice", 8.5),
  ("Bob", 7.0),
  ("Charlie", 9.0),
  ("David", 6.5),
  ("Eve", 8.0)
)
```

Defina uma função que receba essa lista e produza a média da turma, considerando apenas os que foram aprovados (notas maiores ou iguais a 7.0). A função deve ter a seguinte assinatura:

```scala
def averageApproved(students: List[(String, Double)]): Double = {
  // implementação
}
```

[Código](NotasTuplas.scala)

---

## Exercício 3.5

Um sensor reporta valores de temperatura em graus Celsius anotados com timestamps que indicam o momento em que a medição ocorreu. Esses valores são armazenados em uma lista de tuplas, conforme o exemplo a seguir, que representa seis medições de temperatura:

```scala
List(
  (1678886400, 25.5),
  (1678972800, 26.1),
  (1679059200, -60.0),
  (1679145600, 24.8),
  (1679232000, 27.0),
  (1679318400, 25.9)
)
```

Defina uma função que faça o seguinte:

- Elimine todas as temperaturas negativas
- Elimine as leituras cujos timestamps sejam menores que um timestamp informado
- Calcule a média das temperaturas restantes

A função deve ter a seguinte assinatura:

```scala
def avgTemperature(temps: List[(Int, Double)], minTimestamp: Int): Double = {
  // implementação
}
```

[Código](SensorTemperatura.scala)

---

## Exercício 3.6

Defina uma função que receba uma lista de strings e um inteiro, representando um comprimento mínimo e faça o seguinte:

- Elimine todas as strings cujo comprimento seja menor que o valor informado
- Produza a média dos comprimentos das strings restantes.

---

## Exercício 3.7

Uma loja online precisa calcular o preço final dos itens no carrinho de compras após a aplicação dos descontos e a inclusão do frete. O frete e o desconto *de cada item* são dependentes do peso desse item, conforme a tabela a seguir:

| Peso (kg)     | Desconto (%) | Frete (R$) |
|---------------|:------------:|:----------:|
| Até 0.5       | 5%           | 1.0        |
| 0.5 - 1.0     | 10%          | 1.5        |
| 1.0 - 2.0     | 15%          | 2.0        |
| Acima de 2.0  | 20%          | 3.0        |

Os dados do carrinho são representados por uma lista de tuplas, conforme o exemplo:

```scala
List(
  (1, 10.0, 0.5), // (id, preço, peso)
  (2, 20.0, 1.0),
  (3, 15.0, 0.8)
)
```

Defina uma função que calcule o preço final do carrinho, considerando:

- A soma dos preços dos itens
- A aplicação de um desconto sobre o total
- A inclusão do frete, que depende do peso de cada item

A assinatura da função deve ser:

```scala
def calculateFinalPrice(cart: List[(Int, Double, Double)]): Double = {
  // implementação
}
```

[Código](PrecoLoja.scala)