# Quiz — Atividade 3.1: Funções

## Questão 1

Sobre o Cálculo Lambda, assinale a afirmativa correta:

* [ ] Baseia-se em efeitos colaterais e estados mutáveis, onde o operador é utilizado para redefinir ponteiros de escopo.
* [ ] Permite a definição nativa de tipos de dados primitivos e numéricos, que são convertidos em funções somente no momento de avaliação.
* [ ] Trata-se de um sistema formal baseado em variáveis, abstrações de funções lambda e aplicação de funções, sendo equivalente em poder de computação a uma Máquina de Turing.
* [ ] Por ser um modelo puramente matemático, o Cálculo Lambda clássico não possui capacidade para expressar condicionais ou recursão.
* [ ] A operação fundamental de substituição do argumento no corpo da abstração durante a aplicação da função é chamada de conversão.

## Questão 2

Sobre a definição de funções em Scala, assinale todas as alternativas corretas:

* [ ] Parâmetros de funções podem ser mutáveis por padrão.
* [ ] Todas as funções em Scala devem obrigatoriamente explicitar o tipo do resultado produzido.
* [ ] A palavra-chave `return` é geralmente desencorajada em programação funcional.
* [ ] O tipo do resultado produzido pode ser inferido pelo compilador, mas é boa prática especificá-lo.
* [ ] O corpo da função pode ser uma expressão única ou um bloco de código.

## Questão 3

Analise o seguinte código e assinale as alternativas corretas:

```scala
def processData(data: List[Int]): List[Int] = {
  def f1(n: Int): Boolean = n % 2 == 0
  def f2(n: Int): Int = n * n
  data.filter(f1).map(f2)
}
```

* [ ] O código produzirá o quadrado apenas dos números pares da lista.
* [ ] As funções `f1` e `f2` são closures porque capturam o parâmetro `data`.
* [ ] As funções aninhadas não podem acessar o parâmetro `data`.
* [ ] O código utiliza funções aninhadas.
* [ ] As funções `f1` e `f2` são visíveis apenas dentro de `processData`.

## Questão 4

Sobre as aplicações das lambdas (funções anônimas), assinale as alternativas corretas:

* [ ] Podem ser passadas como argumentos para métodos de objetos.
* [ ] Podem ser usadas para criar closures.
* [ ] Permitem criar funções de ordem superior.
* [ ] Só podem ser usadas em coleções.
* [ ] São úteis para tratamento de eventos e callbacks.

## Questão 5

Sobre funções anônimas (lambdas) em Scala, marque as afirmativas corretas:

* [ ] Não podem acessar variáveis do escopo externo.
* [ ] São literais, podendo ser atribuídas a variáveis.
* [ ] Devem sempre ter o tipo do resultado explicitamente declarado.
* [ ] São úteis para funções de ordem superior.
* [ ] Podem ser passadas como argumentos para outras funções.

## Questão 6

Considere o seguinte tipo-função em Scala:

```scala
(String, (Int, Int) => Double) => Boolean
```

O que esse tipo-função representa?

* [ ] Uma função que recebe uma string e um par de inteiros, produzindo um booleano.
* [ ] Uma função que recebe uma string e uma função, e produz um booleano.
* [ ] Uma função que recebe uma string e dois inteiros e produz um booleano.
* [ ] Uma função que recebe uma string, dois inteiros e um double, e avalia para um booleano.
* [ ] Uma função que recebe uma string e produz um double.

## Questão 7

Considere o seguinte tipo-função em Scala:

```scala
((Double, Double) => Int) => String
```

O que esse tipo-função representa?

* [ ] Uma função que recebe uma função e produz uma função.
* [ ] Uma função que recebe como argumento uma função e produz uma string.
* [ ] Uma função que recebe dois doubles e um inteiro e produz uma string.
* [ ] Uma função que recebe dois doubles e produz outra função, que recebe inteiro e produz string.
* [ ] Uma função que recebe dois doubles e produz uma string.

## Questão 8

As Funções de Ordem Superior (Higher-Order Functions — HOFs) representam um dos pilares da programação funcional. Sobre esse conceito e suas aplicações práticas, assinale a afirmativa correta:

* [ ] Em Scala, funções de ordem superior são limitadas a receber funções como argumentos de entrada, sendo impossível definir uma função que produza outra função como resultado.
* [ ] Em Scala, métodos de classe definidos com a palavra-chave `def` são considerados funções de ordem superior nativas.
* [ ] Funções de ordem superior só podem operar sobre funções que tenham exatamente um único parâmetro de entrada (funções unárias).
* [ ] Uma função de ordem superior é aquela que recebe pelo menos uma outra função como argumento, ou produz uma função como resultado, ou ambos.
* [ ] HOFs são recursos exclusivos de linguagens dinamicamente tipadas, pois linguagens estaticamente tipadas não conseguem verificar a assinatura de tipos de argumentos de funções em tempo de compilação.

## Questão 9

Sobre funções de ordem superior em Scala, assinale as alternativas corretas:

* [ ] Não podem ser usadas com funções anônimas.
* [ ] Só podem operar sobre listas de inteiros.
* [ ] Podem receber funções como argumentos.
* [ ] Podem produzir funções como resultado.
* [ ] São inadequadas para manipular coleções de dados.

## Questão 10

Sobre o método `reduce` em Scala, marque as alternativas corretas:

* [ ] Sempre produz uma lista como resultado.
* [ ] Reduz uma coleção a um único valor usando uma função de agregação.
* [ ] Utiliza o primeiro elemento da coleção como valor inicial do acumulador.
* [ ] Produz sempre um valor do tipo `Option`.
* [ ] Lança uma exceção se aplicado a uma lista vazia.

## Questão 11

Sobre o método `filter` em Scala, assinale as afirmativas corretas:

* [ ] Pode produzir uma coleção maior que a original.
* [ ] Pode produzir uma coleção menor que a original.
* [ ] Sempre produz uma coleção do mesmo tamanho que a original.
* [ ] Não modifica a coleção original.
* [ ] Recebe como argumento um predicado.

## Questão 12

Trace a execução do seguinte código e determine o valor de `result`:

```scala
def square(n: Int): Int = n * n

val numbers = List(2, 3, 4)
val result = numbers.map(square).reduce(_ + _)
```

* [ ] 24
* [ ] 36
* [ ] 16
* [ ] 29
* [ ] 9

## Questão 13

Sobre o método `map` em Scala, assinale as afirmativas corretas:

* [ ] Altera o tipo da coleção resultante, por exemplo, converte `List` para `Set` se os tipos dos elementos mudarem.
* [ ] Não modifica a coleção original, produzindo uma nova coleção.
* [ ] Executa as transformações de forma paralela por padrão.
* [ ] Exige que a assinatura de tipos da função passada seja sempre declarada explicitamente.
* [ ] Preserva o tamanho da coleção original.

## Questão 14

A composição de funções é uma operação fundamental na programação funcional. Em Scala, essa operação é oferecida por meio dos métodos `andThen` e `compose`. Sobre as propriedades conceituais dessas operações, assinale a afirmativa correta:

* [ ] O método `compose` aplica a função da esquerda primeiro e passa o resultado para a função da direita.
* [ ] A composição de funções é associativa, o que significa que expressões como `(f andThen g) andThen h` e `f andThen (g andThen h)` produzem o mesmo resultado comportamental, embora as assinaturas intermediárias de tipo devam ser compatíveis.
* [ ] A ordem dos tipos na assinatura de composição é livre, ou seja, podemos compor uma função `f: Int => String` com `g: Double => Boolean` em qualquer ordem, pois o compilador realiza coerção automática.
* [ ] A composição matemática de funções é equivalente a invocar `f.andThen(g)`.
* [ ] A composição de funções exige obrigatoriamente que todas as funções envolvidas sejam puras, disparando erro de compilação em caso de efeitos colaterais.

## Questão 15

Considere o seguinte código:

```scala
val f = (x: Int) => x + 2
val g = (x: Int) => x * 3
val h = (x: Int) => x * x
val p = f andThen g compose h
val result = p(2)
```

Qual será o valor de `result`?

* [ ] 14
* [ ] 144
* [ ] 12
* [ ] 18
* [ ] 48

## Questão 16

Considere o seguinte código:

```scala
val f = (x: Int) => x * 2
val g = (x: Int) => x + 3
val h = f.andThen(g)
val result = h(5)
```

Qual será o valor de `result`?

* [ ] 8
* [ ] 13
* [ ] 26
* [ ] 10
* [ ] 16

## Questão 17

Considere o seguinte código:

```scala
def createMultiplier(factor: Int): Int => Int = {
  (x: Int) => x * factor
}

val triple = createMultiplier(3)
val result = triple(4)
```

Qual será o valor de `result`?

* [ ] 12
* [ ] 16
* [ ] 4
* [ ] 7
* [ ] 9

## Questão 18

O que é uma closure em Scala?

* [ ] Uma função que sombreia variáveis do escopo léxico da função exterior.
* [ ] Uma função que acessa apenas variáveis globais.
* [ ] Uma função que recebe variáveis como parâmetros.
* [ ] Uma função que captura variáveis do ambiente léxico onde foi definida.
* [ ] Uma função que produz outra função como resultado.

## Questão 19

Considere a seguinte definição e chamadas de funções em Scala:

```scala
def scale(x: Int)(y: Int): Int = x * y - y

val f = scale(4)
val r1 = f(5)
val r2 = f(3)
val result = r1 - r2
```

Qual será o valor de `result`?

* [ ] 24
* [ ] 32
* [ ] 6
* [ ] 8
* [ ] 7

## Questão 20

Em relação aos conceitos de Currying e Aplicação Parcial de funções no paradigma funcional e sua implementação em Scala, assinale a alternativa correta:

* [ ] O compilador de Scala impede a aplicação parcial de funções que tenham parâmetros com valores padrão (default parameters).
* [ ] Em Scala, a aplicação parcial só pode ser realizada em funções que passaram previamente pelo processo de currying.
* [ ] Currying permite fixar os argumentos da direita para a esquerda, enquanto a aplicação parcial sempre avalia e fixa os argumentos da esquerda para a direita.
* [ ] Aplicação Parcial é o processo de transformar uma função que recebe múltiplos argumentos em uma cadeia de funções que recebem um único argumento cada, enquanto Currying consiste em fornecer apenas alguns dos argumentos esperados por uma função, resultando em uma nova função que aceita os argumentos restantes.
* [ ] Currying é o processo de transformar uma função que recebe múltiplos argumentos em uma cadeia de funções que recebem um único argumento cada, enquanto Aplicação Parcial consiste em fornecer apenas alguns dos argumentos esperados por uma função, resultando em uma nova função que aceita os argumentos restantes.
