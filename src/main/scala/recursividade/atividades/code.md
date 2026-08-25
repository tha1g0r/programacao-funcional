# Atividade 4.2 - Recursividade

---

## Objetivos

- Praticar o uso de recursividade em Scala com problemas numéricos clássicos.
- Praticar técnicas de otimização de algoritmos recursivos, como memoização e recursão na cauda.

---

## Estrutura da Atividade

A atividade está dividida em dois problemas principais, implementados em dois arquivos:

1. **FactorialSequence.scala** – Sequência de fatoriais
2. **PascalTriangle.scala** – Triângulo de Pascal

---

## Problema 1: Sequência de Fatoriais

### Descrição

A sequência de fatoriais é uma sequência numérica onde cada termo é o fatorial do índice correspondente. A sequência dos n primeiros fatoriais é definida como:

$$0!, 1!, 2!, 3!, 4!, \ldots, n!$$

#### Algoritmo Naive

O algoritmo ingênuo para calcular essa sequência é:

```scala
def factorialSequenceNaive(n: Int): List[BigInt] = {
  def factorial(i: Int): BigInt = {
    if (i <= 1) 1
    else i * factorial(i - 1)
  }
  (0 to n).map(factorial).toList
}
```

**Problema:** O algoritmo é ineficiente com complexidade de tempo $O(n^2)$, pois o cálculo do fatorial de $k$ envolve recalcular o fatorial de $k-1$. Isso causa muitos cálculos repetidos.

Observe a expansão para $n = 5$:

```
0! = 1
1! = 1 · 1
2! = 2 · 1
3! = 3 · 2 · 1
4! = 4 · 3 · 2 · 1
5! = 5 · 4 · 3 · 2 · 1
```

Para calcular 3!, precisamos recalcular 2!. Para calcular 4!, precisamos recalcular 3! novamente. Esse padrão se repete, tornando o algoritmo ineficiente para valores grandes de $n$.

### Exercício 1.1: Memoização

Implemente a função com a seguinte assinatura:

```scala
import scala.collection.mutable

def factorialSequenceMemoized(n: Int, memo: mutable.Map[Int, BigInt]): List[BigInt]
```

**Parâmetros:**
- `n` – número de termos da sequência de fatoriais a serem calculados
- `memo` – mapa mutável que armazena os valores já calculados do fatorial

**Descrição:**
A função deve aplicar a técnica de memoização para evitar cálculos repetidos. Armazene os resultados já calculados em um mapa, de forma que, se o fatorial de um número já tiver sido calculado, ele seja recuperado do mapa em vez de ser recalculado.

Por exemplo, ao calcular o fatorial de 3, a função deve verificar se o fatorial de 2 já foi calculado. Se sim, recupere-o do mapa, evitando o cálculo repetido.

**Nota:** A função deve utilizar memoização corretamente. Você deve necessariamente utilizar `memo`.

**Resultado esperado:**
- Complexidade de tempo: $O(n)$, onde $n$ é o número de termos
- Complexidade de espaço: $O(n)$, devido ao mapa utilizado para armazenar os resultados

### Exercício 1.2: Recursão na Cauda

Implemente a função com a seguinte assinatura:

```scala
@tailrec
def factorialSequenceTailRecursive(n: Int, i: BigInt = 0, acc: BigInt = 1,
  result: List[BigInt] = Nil): List[BigInt]
```

**Parâmetros:**
- `n` – número de termos da sequência de fatoriais a serem calculados
- `i` – índice atual da sequência de fatoriais, começando em 0
- `acc` – acumulador que armazena o valor do fatorial atual
- `result` – lista que armazena os valores da sequência de fatoriais calculados até o momento

**Descrição:**
A desvantagem do algoritmo de memoização é que a cache cresce linearmente com o tamanho do problema. Para resolver essa limitação, use uma intuição simples: para calcular o fatorial de $n$, precisamos apenas do fatorial de $n-1$. Assim, não precisamos de todos os valores intermediários, apenas do último valor calculado.

A função não deve criar variáveis ou estruturas de dados adicionais, restringindo-se aos seus parâmetros. Além disso, a função deve ser necessariamente recursiva na cauda (anotação `@tailrec` obrigatória).

**Resultado esperado:**
- Complexidade de tempo: $O(n)$
- Complexidade de espaço: $O(1)$, pois reduzimos a memoização para um único valor acumulado

---

## Problema 2: Triângulo de Pascal

### Descrição

O triângulo de Pascal é uma estrutura triangular com as seguintes regras de formação:

1. A primeira linha contém o número 1.
2. As extremidades esquerda e direita de cada linha contêm o número 1.
3. Os elementos intermediários de cada linha são formados pela soma dos dois números diretamente acima dele.

**Construção dos primeiros 5 níveis:**

```
        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1
```

### Relação de Recorrência

O coeficiente binomial $C(n, k)$ (ou $\binom{n}{k}$) pode ser calculado pela seguinte relação de recorrência:

$$C(n, k) = \begin{cases}
1 & \text{se } k = 0 \text{ ou } k = n \\
C(n-1, k-1) + C(n-1, k) & \text{caso contrário}
\end{cases}$$

Onde:
- $n$ é o nível (linha) do triângulo de Pascal
- $k$ é a posição (coluna) do elemento na linha

**Exemplo:** Para calcular $C(3, 2)$:

```
C(3,2) = C(2,1) + C(2,2)
C(2,1) = C(1,0) + C(1,1)
C(1,0) = 1
C(1,1) = 1
C(2,1) = 1 + 1 = 2
C(2,2) = 1
C(3,2) = 2 + 1 = 3
```

### Exercício 2.1: Recursão Direta

Implemente a função com a seguinte assinatura:

```scala
def pascalRecursive(n: Int, k: Int): BigInt
```

**Parâmetros:**
- `n` – nível do triângulo de Pascal
- `k` – posição do elemento na linha

**Descrição:**
A função deve calcular o coeficiente binomial $C(n, k)$ utilizando a relação de recorrência apresentada acima. A função deve ser recursiva direta, ou seja, **não deve utilizar otimizações** como memoização ou recursão na cauda.

**Resultado esperado:**
- Complexidade de tempo: $O(2^{\max(n,k)})$ (no pior caso)
- Complexidade de espaço: $O(n)$, devido à profundidade da recursão

### Exercício 2.2: Memoização

Implemente a função com a seguinte assinatura:

```scala
import scala.collection.mutable

def pascalMemoized(n: Int, k: Int, memo: mutable.Map[(Int, Int), BigInt]): BigInt
```

**Parâmetros:**
- `n` – nível do triângulo de Pascal
- `k` – posição do elemento na linha
- `memo` – mapa mutável que armazena os valores já calculados do coeficiente binomial

**Descrição:**
A função deve aplicar a técnica de memoização para evitar cálculos repetidos. Armazene os resultados já calculados em um mapa, de forma que, se o coeficiente binomial já tiver sido calculado, ele seja recuperado do mapa em vez de ser recalculado.

**Nota:** O parâmetro `memo` é utilizado pelos testes automatizados para verificar se a função está utilizando memoização corretamente. Você deve necessariamente utilizar esse mapa, caso contrário seu programa não passará nos testes automatizados.

**Resultado esperado:**
- Complexidade de tempo: $O(n \cdot k)$, pois é necessário calcular cada valor no máximo uma vez
- Complexidade de espaço: $O(n \cdot k)$, devido ao tamanho final da cache de memoização

### Exercício 2.3: Recursão na Cauda

Implemente a função com a seguinte assinatura:

```scala
def pascalTailRecursive(n: Int, k: Int): BigInt
```

**Descrição:**
A desvantagem do algoritmo de memoização é que a cache cresce linearmente com o tamanho do problema. Para melhorar o uso de espaço, adote uma definição iterativa do coeficiente binomial, mais eficiente em termos de espaço.

#### Intuição Matemática

O coeficiente binomial pode ser calculado pela fórmula multiplicativa:

$$\binom{n}{k} = \frac{n!}{k!(n-k)!} = \frac{n \cdot (n-1) \cdot (n-2) \cdots (n-k+1)}{k \cdot (k-1) \cdot (k-2) \cdots 1}$$

Isso pode ser simplificado para:

$$\binom{n}{k} = \prod_{i=1}^{k} \frac{n - i + 1}{i}$$

#### Algoritmo Iterativo

```scala
def pascalIterative(n: Int, k: Int): BigInt = {
  if (k < 0 || k > n) return 0
  if (k == 0 || k == n) return 1
  
  var res = BigInt(1)
  var i = 1
  
  while (i <= k) {
    res = res * (n - i + 1) / i
    i += 1
  }
  
  return res
}
```

#### O Que Fazer

Converta o algoritmo iterativo acima em uma função recursiva na cauda. A função recursiva na cauda deve ser uma função **interna** a `pascalTailRecursive`, conforme exemplos vistos em aula:

```scala
def pascalTailRecursive(n: Int, k: Int): BigInt = {
  // validações e tratamentos de casos base
  
  @tailrec
  def pascalHelper(...): BigInt = {
    // implementação recursiva na cauda
  }
  
  pascalHelper(...)
}
```

**Resultado esperado:**
- Complexidade de tempo: $O(n \cdot k)$
- Complexidade de espaço: $O(1)$, pois não utilizamos memória extra proporcional ao tamanho do problema

---

## Restrições

Todas as funções devem ser **puras**, ou seja, não devem ter efeitos colaterais e devem ser determinísticas. **Não são permitidos:**

- Uso de variáveis mutáveis (`var`)
- Uso de estruturas de controle imperativas (`for`, `while`, `do-while`)
- Uso de estruturas de dados mutáveis (exceção: o `Map` mutável especificado nos enunciados)
- Disparo de exceções (`throw`, `try-catch`)
- Uso de funções de entrada/saída (`print`, `readLine`, `System.out.println`)
- Uso de funções que não sejam puras (`System.exit`, etc.)
- Uso de bibliotecas externas que não sejam puras
- Outros comportamentos imperativos
