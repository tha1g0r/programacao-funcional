# Capítulo 4 — Exercícios (Recursividade)

## Exercício 4.1

A exponenciação de um número `base` elevado a um expoente inteiro não negativo `exp` (`base^exp`) pode ser definida recursivamente como:

```
base^exp = 1                         se exp = 0
base^exp = base × base^(exp-1)       caso contrário
```

Com base nessa definição:

- **a)** Escreva uma função recursiva simples `def power(base: Double, exp: Int): Double`.
- **b)** Projete uma versão recursiva na cauda dessa mesma função com a assinatura `def powerTail(base: Double, exp: Int): Double`. Utilize uma função auxiliar recursiva na cauda anotada com `@tailrec`.

[Código](Expoente.scala)

---

## Exercício 4.2

A exponenciação binária (fast power) permite calcular `base^exp` com complexidade de tempo logarítmica, O(log exp), explorando a seguinte definição recursiva:

```
base^exp = (base²)^(exp/2)       se exp for par
base^exp = base × base^(exp-1)   se exp for ímpar
```

Com base nessa definição:

- **a)** Escreva uma função recursiva simples `def fastPower(base: Double, exp: Int): Double`.
- **b)** Projete uma versão recursiva na cauda dessa mesma função com a assinatura `def fastPowerTail(base: Double, exp: Int): Double`. Para isso, utilize a técnica de manter um estado com três variáveis (`acc`, `base`, `exp`) mantendo a relação invariante `acc × base^exp = constante`. Inicialmente, `acc = 1.0`. A cada passo recursivo:
  - Se `exp` for par, a base é elevada ao quadrado e `exp` é dividido por 2.
  - Se `exp` for ímpar, multiplica-se `acc` pela base atual e decrementa-se `exp` em 1.
  - Se `exp = 0`, o resultado é `acc`.

  Utilize uma função auxiliar recursiva na cauda anotada com `@tailrec`.

[Código](ExpoenteBinario.scala)

---

## Exercício 4.3

Assim como a exponenciação binária, a multiplicação de dois inteiros positivos `a` e `b` (`a × b`) pode ser otimizada para executar com complexidade de tempo logarítmica O(log b) se dispusermos apenas de operações de adição, duplicação e divisão por dois. Considere as seguintes funções básicas pré-definidas:

```scala
def double(x: Int): Int = x + x
def halve(x: Int): Int = x / 2
```

A multiplicação rápida pode ser definida recursivamente como:

```
a × b = 0                        se b = 0
a × b = double(a × halve(b))     se b for par
a × b = a + a × (b-1)            se b for ímpar
```

Com base nessa definição:

- **a)** Escreva uma função recursiva simples `def fastMultiply(a: Int, b: Int): Int`.
- **b)** Projete uma versão recursiva na cauda dessa mesma função com a assinatura `def fastMultiplyTail(a: Int, b: Int): Int`. Utilize a relação invariante `acc + a × b = constante` (inicialmente, `acc = 0`).

**Dica:**
- Se `b` for par, a chamada recursiva é feita duplicando `a` e dividindo `b` por 2.
- Se `b` for ímpar, acumula-se `a` no acumulador e decrementa-se `b` em 1.
- Se `b = 0`, o resultado é o acumulador.

Utilize uma função auxiliar recursiva na cauda anotada com `@tailrec`.

[Código](FastMultiply.scala)

---

## Exercício 4.4

O Máximo Divisor Comum (MDC) de dois números inteiros não-negativos `a` e `b` pode ser calculado utilizando o clássico Algoritmo de Euclides. A definição recursiva do MDC é:

```
mdc(a, b) = a                  se b = 0
mdc(a, b) = mdc(b, a mod b)    se b > 0
```

Escreva a função recursiva `def gcd(a: Int, b: Int): Int` utilizando a definição acima. Explique por que essa função é inerentemente recursiva na cauda e aplique a anotação `@tailrec`.

[Código](Mdc.scala)

---

## Exercício 4.5

A aproximação do valor do seno de um ângulo `x` em radianos (`sin(x)`) pode ser computada recursivamente tirando proveito da identidade trigonométrica:

```
sin(x) = 3·sin(x/3) − 4·sin³(x/3)
```

Para ângulos muito pequenos, podemos usar a aproximação linear de que `sin(x) ≈ x` como caso base. Considere que o ângulo `x` é pequeno o suficiente quando o seu valor absoluto for menor do que 0.1 radianos (`|x| < 0.1`).

Escreva a função recursiva `def sine(x: Double): Double` para calcular o seno aproximado de um ângulo qualquer com base nesse processo. Analise se sua implementação é recursiva na cauda e discuta as implicações disso em termos de uso de memória.

[Código](Seno.scala)

---

## Exercício 4.6

Deseja-se implementar a operação de inversão de uma lista de forma eficiente. Por exemplo, dada a lista `List(1, 2, 3)`, a função deve retornar `List(3, 2, 1)`.

Implemente uma função recursiva na cauda `def reverse[A](list: List[A]): List[A]` usando apenas as propriedades básicas de lista (`isEmpty`, `head` e `tail`), um acumulador auxiliar e a anotação `@tailrec`.

[Código](ListaInversa.scala)

---

## Exercício 4.7

Muitos laços de repetição imperativos em linguagens tradicionais contêm variáveis de estado mutáveis e condições de parada. Considere o seguinte código imperativo para encontrar o primeiro índice de um número inteiro alvo em uma lista (retornando -1 caso não encontre):

```scala
def findIndex(list: List[Int], target: Int): Int = {
  var i = 0
  var found = false
  var index = -1
  while (i < list.length && !found) {
    if (list(i) == target) {
      found = true
      index = i
    }
    i += 1
  }
  index
}
```

Converta a lógica acima para uma função puramente funcional e recursiva na cauda, com a assinatura `def findIndex(list: List[Int], target: Int): Int`. Utilize as propriedades básicas de lista (`isEmpty`, `head` e `tail`) para percorrer a lista, a anotação `@tailrec` e nenhum estado mutável ou comando de laço (`while`).

[Código](FindIndex.scala)

---

## Exercício 4.8

A sequência de Tribonacci é uma variação da famosa sequência de Fibonacci, na qual cada termo a partir do quarto elemento é a soma dos três termos anteriores. Ela é definida formalmente como:

```
T(n) = 0                              se n = 0
T(n) = 0                              se n = 1
T(n) = 1                              se n = 2
T(n) = T(n-1) + T(n-2) + T(n-3)       se n ≥ 3
```

Com base nesta definição:

- **a)** Escreva uma função recursiva simples (múltipla) `def tribonacci(n: Int): Int`. Explique por que essa abordagem tem complexidade de tempo exponencial.
- **b)** Implemente uma versão recursiva na cauda `def tribonacciTail(n: Int): Int` utilizando três acumuladores e a anotação `@tailrec`, de forma que ela compute o resultado com complexidade de tempo linear.

---

## Exercício 4.9

Em algoritmos de ordenação por divisão e conquista (como o Merge Sort), um passo fundamental é a mesclagem (*merge*) de duas sequências ordenadas de modo a produzir uma única sequência ordenada.

Escreva uma função recursiva `def merge(xs: List[Int], ys: List[Int]): List[Int]` que realize essa operação de mesclagem. Use as propriedades básicas de lista (`isEmpty`, `head` e `tail`) para tratar os casos base e os passos recursivos.
