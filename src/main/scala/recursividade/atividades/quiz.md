# Quiz – Atividade 4.1: Recursividade

## Questão 1

Quais são as três características principais de uma função recursiva?

* [ ] a. Condição, loop e incremento.
* [ ] b. Auto-referência, caso base e caso recursivo.
* [ ] c. Mutabilidade, iteração e condição de parada.
* [ ] d. Parâmetros, retorno e efeitos colaterais.
* [ ] e. Entrada, processamento e saída.

## Questão 2

Sobre a comparação entre abordagens imperativas (estruturadas com laços) e recursivas para controle de repetição, assinale as alternativas corretas:

* [ ] a. A recursão simples consome menos espaço na pilha de execução do que um loop imperativo.
* [ ] b. A solução imperativa estruturada com laços geralmente depende de variáveis de controle e mutação de estado.
* [ ] c. A recursão pura alcança repetição por meio de novas chamadas de função com novos argumentos, sem mutabilidade.
* [ ] d. A formulação recursiva expressa a lógica de repetição de forma mais próxima a definições matemáticas indutivas.
* [ ] e. Loops imperativos (como while ou for) não podem ser convertidos para equivalentes recursivos.

## Questão 3

Sobre casos base em funções recursivas, assinale as alternativas corretas:

* [ ] a. Devem sempre retornar zero.
* [ ] b. São opcionais em funções recursivas.
* [ ] c. Podem ser múltiplos em uma função.
* [ ] d. Definem quando a recursão deve parar.
* [ ] e. São essenciais para evitar chamadas infinitas.

## Questão 4

Analise as três implementações abaixo e classifique cada uma quanto à recursão na cauda.

**Função A:**

```scala
def a(n: Int, acc: Int = 0): Int = {
  if (n == 0) acc
  else a(n - 1, acc + 1)
}
```

**Função B:**

```scala
def b(n: Int): Int = {
  if (n == 0) 0
  else 1 + b(n - 1)
}
```

**Função C:**

```scala
def c(n: Int, result: Int = 1): Int = {
  if (n <= 1) result
  else c(n - 1, result * n)
}
```

Classifique as funções A, B e C, respectivamente:

* [ ] a. Recursiva na cauda; Recursiva na cauda; Recursiva na cauda.
* [ ] b. Não recursiva na cauda; Recursiva na cauda; Não recursiva na cauda.
* [ ] c. Recursiva na cauda; Não recursiva na cauda; Recursiva na cauda.
* [ ] d. Não recursiva na cauda; Não recursiva na cauda; Recursiva na cauda.
* [ ] e. Recursiva na cauda; Não recursiva na cauda; Não recursiva na cauda.

## Questão 5

Sobre consumo de memória em recursões, considerando recursão simples em contraposição à recursão na cauda, assinale as alternativas corretas:

* [ ] a. Todas as linguagens funcionais implementam TCO (Tail Call Optimization) automaticamente.
* [ ] b. Recursão na cauda com otimização mantém consumo de memória constante.
* [ ] c. Recursão simples consome memória proporcional à profundidade da recursão.
* [ ] d. Recursão é sempre mais eficiente em memória que iteração.
* [ ] e. Stack overflow ocorre quando a pilha de chamadas excede o limite.

## Questão 6

Sobre otimização de chamada na cauda (TCO, ou Tail Call Optimization) em Scala, assinale as alternativas corretas:

* [ ] a. Melhora a legibilidade do código.
* [ ] b. Funciona automaticamente em qualquer função recursiva.
* [ ] c. Evita o estouro de pilha em recursões profundas.
* [ ] d. Reduz significativamente o consumo de memória.
* [ ] e. Transforma chamadas recursivas em saltos diretos na implementação.

## Questão 7

Analise o código abaixo e identifique qual afirmação está correta:

```scala
def mystery(n: Int): Int = {
  if (n <= 0) 1
  else n * mystery(n - 1)
}
```

* [ ] a. A função não possui caso base.
* [ ] b. A função não é recursiva na cauda.
* [ ] c. A função é recursiva na cauda.
* [ ] d. A função irá causar estouro de pilha para qualquer valor de n.
* [ ] e. A função não pode ser otimizada.

## Questão 8

Considere a seguinte função recursiva:

```scala
def alpha(x: Int): Int = {
  if (x <= 0) 0
  else x * x + alpha(x - 1)
}
```

Analise as quatro implementações tail recursive abaixo e assinale quais são funcionalmente equivalentes à função original.

**Opção A:**

```scala
def beta(x: Int, acc: Int = 0): Int = {
  if (x <= 0) acc
  else beta(x - 1, acc + x * x)
}
```

**Opção B:**

```scala
def gamma(x: Int, acc: Int = 0): Int = {
  if (x <= 0) acc
  else gamma(x - 1, acc + x)
}
```

**Opção C:**

```scala
def delta(i: Int, x: Int, acc: Int = 0): Int = {
  if (i > x) acc
  else delta(i + 1, x, acc + i * i)
}
```

**Opção D:**

```scala
def epsilon(i: Int, x: Int, acc: Int = 1): Int = {
  if (i > x) acc
  else epsilon(i + 1, x, acc + i * i)
}
```

* [ ] a. Todas as opções são equivalentes.
* [ ] b. Apenas as Opções A e B são equivalentes.
* [ ] c. Apenas a Opção A é equivalente.
* [ ] d. Apenas as Opções A e C são equivalentes.
* [ ] e. Nenhuma das opções é equivalente.

## Questão 9

Uma chamada na cauda (tail call) é caracterizada por:

* [ ] a. Sempre retornar void.
* [ ] b. Usar apenas parâmetros primitivos.
* [ ] c. Só poder ser usada em funções recursivas.
* [ ] d. Ser a primeira operação da função.
* [ ] e. Ser a última operação executada pela função antes de retornar.

## Questão 10

O que acontecerá se executarmos o código abaixo com um valor alto de `n` (ex.: `100000`)?

```scala
def g(n: Int, acc: Int = 0): Int = {
  if (n <= 0) acc
  else g(n - 1, acc + 1)
}
```

* [ ] a. Retornará resultado incorreto para valores altos.
* [ ] b. Causará stack overflow.
* [ ] c. Será mais lenta que a versão não tail recursive.
* [ ] d. Executará normalmente sem problemas.
* [ ] e. Executará infinitamente.

## Questão 11

Considere a seguinte função iterativa que calcula o produto dos números ímpares de 1 até `n`:

```scala
def produtoImpares(n: Int): Int = {
  var produto = 1
  var i = 1
  while (i <= n) {
    if (i % 2 == 1) {
      produto *= i
    }
    i += 1
  }
  return produto
}
```

Analise as seguintes implementações recursivas:

**Implementação A:**

```scala
def produtoImpares(n: Int): Int = {
  if (n <= 0) 1
  else if (n % 2 == 1) n * produtoImpares(n - 1)
  else produtoImpares(n - 1)
}
```

**Implementação B:**

```scala
def produtoImpares(n: Int, i: Int = 1, produto: Int = 1): Int = {
  if (i > n) produto
  else if (i % 2 == 1) produtoImpares(n, i + 1, produto * i)
  else produtoImpares(n, i + 1, produto)
}
```

**Implementação C:**

```scala
def produtoImpares(n: Int): Int = {
  if (n == 1) 1
  else n + produtoImpares(n - 1)
}
```

**Implementação D:**

```scala
def produtoImpares(n: Int, acc: Int = 0): Int = {
  if (n <= 0) acc
  else if (n % 2 == 1) produtoImpares(n - 1, acc + n)
  else produtoImpares(n - 1, acc)
}
```

**Implementação E:**

```scala
def produtoImpares(n: Int): Int = {
  if (n <= 1) n
  else produtoImpares(n - 2) * n
}
```

Quais das implementações representam uma conversão válida da função iterativa acima?

* [ ] a. Implementação A
* [ ] b. Implementação D
* [ ] c. Implementação E
* [ ] d. Implementação B
* [ ] e. Implementação C

## Questão 12

Na conversão de loops imperativos para funções recursivas, assinale as alternativas corretas:

* [ ] a. A condição do loop é utilizada para formar o caso base.
* [ ] b. O corpo do loop torna-se o passo recursivo.
* [ ] c. É impossível converter loops com múltiplas variáveis de controle.
* [ ] d. A conversão sempre resulta em código mais eficiente.
* [ ] e. As variáveis de controle do loop tornam-se parâmetros da função.

## Questão 13

Sobre a implementação recursiva ingênua do fatorial, reproduzida abaixo, assinale as alternativas corretas.

```scala
def factorial(n: Int): Int = {
  if (n <= 1) 1
  else n * factorial(n - 1)
}
```

* [ ] a. Usa menos memória que uma implementação não-recursiva.
* [ ] b. É sempre mais eficiente que uma implementação iterativa.
* [ ] c. Pode causar estouro de pilha para valores grandes de n.
* [ ] d. É computacionalmente ineficiente porque não apresenta recursão na cauda.
* [ ] e. A anotação `@tailrec` não pode ser aplicada a esta função.

## Questão 14

Considere a seguinte implementação recursiva clássica para calcular `x` elevado a `n`:

```scala
def power(x: Int, n: Int): Int = {
  if (n == 0) 1
  else x * power(x, n - 1)
}
```

Analise as seguintes tentativas de conversão para recursão na cauda:

**A)**

```scala
def power(x: Int, n: Int, acc: Int = 1): Int = {
  if (n == 0) acc
  else power(x, n - 1, acc * x)
}
```

**B)**

```scala
def power(x: Int, n: Int, acc: Int = 0): Int = {
  if (n == 0) acc
  else power(x, n - 1, acc + x)
}
```

**C)**

```scala
def power(x: Int, n: Int, acc: Int = 1): Int = {
  if (n == 0) 1
  else power(x, n - 1, acc * x)
}
```

**D)**

```scala
def power(x: Int, n: Int, acc: Int = 1): Int = {
  if (n == 0) acc
  else power(x, n - 1, x * acc)
}
```

**E)**

```scala
def power(x: Int, n: Int, acc: Int = 1): Int = {
  if (n <= 0) acc
  else power(x, n - 1, acc * x)
}
```

Quais implementações representam conversões corretas para recursão na cauda?

* [ ] a. Implementação D
* [ ] b. Implementação A
* [ ] c. Implementação C
* [ ] d. Implementação E
* [ ] e. Implementação B

## Questão 15

Analise as seguintes implementações de fatorial:

**A)**

```scala
def factorial(n: BigInt): BigInt = {
  if (n <= 1) 1
  else n * factorial(n - 1)
}
```

**B)**

```scala
def factorial(n: BigInt, acc: BigInt = 1): BigInt = {
  if (n <= 1) acc
  else factorial(n - 1, acc * n)
}
```

**C)**

```scala
def factorial(n: BigInt): BigInt = {
  1 + n * factorial(n - 1)
}
```

**D)**

```scala
def factorial(n: BigInt, acc: BigInt = 1): BigInt = {
  if (n <= 1) acc + n
  else factorial(n - 1, acc * n)
}
```

**E)**

```scala
def factorial(n: BigInt): BigInt = {
  factorial(n - 1) * n
}
```

Qual das implementações representa corretamente o fatorial usando recursão na cauda (tail recursion)?

* [ ] a. Implementação C
* [ ] b. Implementação E
* [ ] c. Implementação D
* [ ] d. Implementação B
* [ ] e. Implementação A

## Questão 16

Sobre os requisitos para memoização eficaz, assinale as alternativas corretas:

* [ ] a. A função memoizada não precisa ter transparência referencial.
* [ ] b. A função memoizada deve ter transparência referencial.
* [ ] c. Os argumentos da função devem ser imutáveis.
* [ ] d. A memoização é altamente vantajosa mesmo se a função for chamada quase sempre com argumentos inéditos.
* [ ] e. A operação memoizada deve ser computacionalmente mais custosa que a manutenção do cache.

## Questão 17

Sobre memoização aplicada ao cálculo de Fibonacci, considere:

```scala
def memoize[I, O](f: I => O): I => O = {
  val cache = mutable.Map.empty[I, O]
  (arg: I) => cache.getOrElseUpdate(arg, f(arg))
}

val fibonacciMemoized: BigInt => BigInt = memoize { n =>
  if (n == 0) BigInt(0)
  else if (n == 1) BigInt(1)
  else fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2)
}
```

Assinale as alternativas corretas:

* [ ] a. Requer transparência referencial da função original.
* [ ] b. Armazena resultados de chamadas anteriores para evitar recálculos.
* [ ] c. Funciona melhor com funções que têm efeitos colaterais.
* [ ] d. Reduz a complexidade de tempo de O(2ⁿ) para O(n).
* [ ] e. Reduz a complexidade de espaço para O(1).

## Questão 18

Considere as seguintes implementações de Fibonacci:

**Implementação Ingênua:**

```scala
def fibonacci(n: Int): BigInt = {
  if (n <= 1) n
  else fibonacci(n - 1) + fibonacci(n - 2)
}
```

**Implementação Tail-Recursive:**

```scala
def fibonacci(n: Int, a: BigInt = 0, b: BigInt = 1): BigInt = {
  if (n == 0) a
  else if (n == 1) b
  else fibonacci(n - 1, b, a + b)
}
```

**Implementação Iterativa:**

```scala
def fibonacci(n: Int): BigInt = {
  if (n <= 1) n
  else {
    var a = 0
    var b = 1
    for (i <- 2 to n) {
      val temp = a + b
      a = b
      b = temp
    }
    b
  }
}
```

**Implementação com Memoização:**

```scala
def fibonacci(n: Int): BigInt = {
  val cache = mutable.Map[Int, BigInt]()
  def fib(n: Int): BigInt = {
    cache.getOrElseUpdate(n, {
      if (n <= 1) n
      else fib(n - 1) + fib(n - 2)
    })
  }
  fib(n)
}
```

Comparando essas implementações, assinale as alternativas corretas:

* [ ] a. Memoização é mais útil quando a mesma função é chamada múltiplas vezes com os mesmos argumentos.
* [ ] b. Para valores muito grandes de n, as versões iterativa e tail-recursive são preferíveis.
* [ ] c. A implementação ingênua é adequada para valores grandes de n, por exemplo, n = 100.
* [ ] d. A versão com memoização sempre usa menos memória que a iterativa.
* [ ] e. A implementação tail-recursive combina eficiência com pureza funcional.

## Questão 19

Sobre performance e complexidade nas implementações de Fibonacci vistas em aula, considere o seguinte quadro comparativo de tempos de execução para diferentes valores de `n`:

| n    | Ingênua recursiva | Memoizada | Recursiva na cauda | Iterativa |
| ---- | ----------------: | --------: | -----------------: | --------: |
| 10   |              1 ms |      6 μs |             147 μs |    154 μs |
| 20   |              3 ms |     61 μs |               1 μs |     18 μs |
| 30   |             35 ms |     60 μs |               2 μs |     16 μs |
| 35   |            126 ms |     33 μs |               2 μs |     18 μs |
| 40   |               1 s |     38 μs |               4 μs |     28 μs |
| 45   |              15 s |     32 μs |               2 μs |     20 μs |
| 50   |              73 s |      8 μs |              22 μs |         — |
| 100  |                 — |    223 μs |              18 μs |     62 μs |
| 500  |                 — |      1 ms |             172 μs |    217 μs |
| 1000 |                 — |    543 μs |             145 μs |    154 μs |

Com base nesses dados, assinale as alternativas corretas:

* [ ] a. A implementação com memoização sempre supera a recursiva na cauda em velocidade.
* [ ] b. A partir de n = 50, a implementação ingênua se torna praticamente inviável.
* [ ] c. Para n = 45, a diferença de tempo entre implementação ingênua e a recursiva na cauda é de segundos versus microssegundos.
* [ ] d. Para problemas com subproblemas sobrepostos, memoização oferece ganhos significativos.
* [ ] e. Complexidade de espaço O(n) é sempre preferível a O(1).

## Questão 20

Sobre as limitações e considerações da memoização, assinale as alternativas corretas:

* [ ] a. Pode não ser eficaz se a função for chamada com argumentos sempre diferentes.
* [ ] b. Pode consumir memória excessiva se não houver limitação do tamanho do cache.
* [ ] c. É incompatível com programação concorrente devido à mutabilidade do cache.
* [ ] d. Memoização sempre melhora o desempenho independentemente do padrão de uso.
* [ ] e. O overhead de manutenção do cache pode superar os benefícios para funções simples.
