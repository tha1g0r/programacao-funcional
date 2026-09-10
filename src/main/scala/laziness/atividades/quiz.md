# Quiz: Avaliação Preguiçosa (Lazy Evaluation)

## Questão 1

Quais são as principais aplicações da avaliação preguiçosa?

**Escolha uma opção:**

- [x] a. Estruturas de dados infinitas e criação de fluxo de avaliação customizado.
- [ ] b. Apenas para otimização de algoritmos de ordenação.
- [ ] c. Somente criação de interfaces gráficas e manipulação de arquivos.
- [ ] d. Apenas otimização de memória e processamento paralelo.
- [ ] e. Exclusivamente para programação orientada a objetos.

---

## Questão 2

Sobre a classificação de linguagens quanto ao tipo de avaliação, assinale as alternativas corretas:

**Escolha uma ou mais:**

- [x] a. Haskell e Miranda são exemplos de linguagens não-estritas.
- [x] b. Scala oferece mecanismos de avaliação preguiçosa mesmo sendo uma linguagem estrita.
- [ ] c. Linguagens não-estritas não podem implementar avaliação ansiosa.
- [ ] d. Linguagens estritas não podem implementar mecanismos de avaliação preguiçosa.
- [x] e. Java, C, Python e Scala são exemplos de linguagens estritas.

---

## Questão 3

Sobre o uso de avaliação preguiçosa para otimização, assinale as alternativas corretas:

**Escolha uma ou mais:**

- [x] a. É útil quando valores podem nunca ser necessários.
- [ ] b. Sempre resulta em programas mais rápidos.
- [x] c. Permite adiar operações custosas até serem realmente necessárias.
- [x] d. É especialmente valiosa em inicialização de objetos complexos.
- [ ] e. Deve ser usada em todas as variáveis para máxima eficiência.

---

## Questão 4

Sobre as considerações de quando usar avaliação preguiçosa, assinale as alternativas corretas:

**Escolha uma ou mais:**

- [x] a. É útil para operações que podem falhar ou gerar exceções.
- [x] b. É recomendada para propriedades custosas que podem não ser acessadas.
- [ ] c. Sempre melhora a performance independentemente do contexto.
- [x] d. É benéfica quando há incerteza se um valor será necessário.
- [x] e. Deve ser evitada em computações que são sempre necessárias.

---

## Questão 5

Em qual cenário a avaliação preguiçosa seria MENOS benéfica?

**Escolha uma opção:**

- [x] a. Valores que são sempre acessados imediatamente após a definição.
- [ ] b. Propriedades custosas de objetos que são raramente acessadas.
- [ ] c. Operações que podem gerar erros se avaliadas desnecessariamente.
- [ ] d. Argumentos de funções que podem não ser utilizados.
- [ ] e. Estruturas de dados potencialmente infinitas.

---

## Questão 6

Considere o seguinte código em Scala:

```scala
lazy val x = {
  println("Avaliando x")
  42
}
println("Amarração finalizada")
println(x)
```

Qual será a ordem de saída do programa?

**Escolha uma opção:**

- [ ] a. "Avaliando x", "Amarração finalizada", 42
- [ ] b. Apenas 42 será impresso.
- [ ] c. 42, "Amarração finalizada", "Avaliando x"
- [x] d. "Amarração finalizada", "Avaliando x", 42
- [ ] e. "Avaliando x", 42, "Amarração finalizada"

---

## Questão 7

Sobre memoização em amarrações preguiçosas (lazy val), assinale as alternativas corretas:

**Escolha uma ou mais:**

- [ ] a. Cada acesso à variável lazy resulta em nova avaliação.
- [x] b. A primeira avaliação calcula e armazena o valor para acessos futuros.
- [ ] c. Memoização não se aplica a amarrações preguiçosas, apenas a argumentos preguiçosos.
- [x] d. Acessos subsequentes retornam o valor já calculado sem recalcular.
- [x] e. O processo envolve computação adiada seguida de armazenamento do resultado.

---

## Questão 8

Sobre o uso de amarrações preguiçosas, assinale as alternativas corretas:

**Escolha uma ou mais:**

- [ ] a. Sempre tornam o programa mais rápido.
- [x] b. São especialmente úteis quando o valor é computacionalmente caro.
- [x] c. Evitam cálculos desnecessários quando a variável pode nunca ser acessada.
- [ ] d. Deve-se ter como boa prática usar amarrações preguiçosas para todas as variáveis em Scala.
- [x] e. Permitem inicialização rápida de objetos com propriedades custosas.

---

## Questão 9

Sobre propriedades preguiçosas em classes, assinale as alternativas corretas:

**Escolha uma ou mais:**

- [x] a. Uma vez calculadas, são memoizadas para acessos futuros.
- [ ] b. Não podem ser usadas em case classes.
- [x] c. São especialmente úteis em classes imutáveis.
- [x] d. São úteis para adiar inicialização de propriedades custosas.
- [ ] e. Devem ser recalculadas sempre que acessadas.

---

## Questão 10

Sobre a diferença entre propriedades preguiçosas e métodos, ambos de classes, assinale as alternativas corretas:

**Escolha uma ou mais:**

- [ ] a. Não há diferença prática entre eles.
- [x] b. Propriedades preguiçosas são calculadas apenas uma vez.
- [ ] c. Métodos são mais eficientes para cálculos custosos repetidos.
- [x] d. Propriedades preguiçosas são mais eficientes para cálculos custosos repetidos.
- [x] e. Métodos são reavaliados a cada chamada.

---

## Questão 11

Considere uma classe de análise de texto:

```scala
case class TextAnalyzer(text: String) {
  def wordCount: Int = {
    println("Contando palavras...")
    text.split("\\s+").length
  }

  lazy val characterCount: Int = {
    println("Contando caracteres...")
    text.length
  }

  lazy val lineCount: Int = {
    println("Contando linhas...")
    text.split("\n").length
  }
}

val analyzer = TextAnalyzer("Scala é uma linguagem funcional")
println("Objeto criado")

println(s"Palavras: ${analyzer.wordCount}")
println(s"Caracteres: ${analyzer.characterCount}")
println(s"Média caracteres/palavra: ${analyzer.characterCount / analyzer.wordCount.toDouble}")
```

Quantas vezes cada mensagem será impressa?

**Escolha uma opção:**

- [ ] a. "Contando palavras...": 2 vezes, "Contando caracteres...": 2 vezes, "Contando linhas...": 0 vezes
- [ ] b. "Contando palavras...": 1 vez, "Contando caracteres...": 2 vezes, "Contando linhas...": 0 vezes
- [x] c. "Contando palavras...": 2 vezes, "Contando caracteres...": 1 vez, "Contando linhas...": 0 vezes
- [ ] d. "Contando palavras...": 1 vez, "Contando caracteres...": 1 vez, "Contando linhas...": 1 vez
- [ ] e. "Contando palavras...": 2 vezes, "Contando caracteres...": 1 vez, "Contando linhas...": 1 vez

---

## Questão 12

Considere o seguinte código que simula chamada por necessidade:

```scala
class LazyValue[T](computation: => T) {
  lazy val value: T = {
    println("Executando computação...")
    computation
  } // lazy val value é o "cache" do resultado de computation

  def get: T = value
}

def expensiveComputation(): String = {
  println("Computação custosa executada")
  Thread.sleep(100)
  "resultado"
}

val lazyVal = new LazyValue(expensiveComputation())
println("LazyValue criada")
println(s"Primeiro acesso: ${lazyVal.get}")
println(s"Segundo acesso: ${lazyVal.get}")
println(s"Terceiro acesso: ${lazyVal.get}")
```

Quantas vezes "Computação custosa executada" será impresso?

**Escolha uma opção:**

- [x] a. Uma vez - na primeira chamada de get
- [ ] b. Duas vezes - primeira e segunda chamada
- [ ] c. Nenhuma vez - a computação nunca é executada
- [ ] d. Três vezes - a cada acesso
- [ ] e. Quatro vezes - incluindo a criação da LazyValue

---

## Questão 13

Considere o seguinte código com chamada por nome:

```scala
def add(x: => Int, y: => Int): Int = {
  println("Corpo da função iniciado")
  x + y
}

val result = add(expensiveComputation(3), expensiveComputation(4))
```

Quando as chamadas da função `expensiveComputation` serão executadas?

**Escolha uma opção:**

- [ ] a. Após a execução do corpo da função add.
- [ ] b. Antes da execução do corpo da função add.
- [ ] c. Nunca, pois não são necessárias.
- [ ] d. Apenas se elas forem referenciadas fora do corpo da função.
- [x] e. Durante a execução do corpo da função add.

---

## Questão 14

Considere o seguinte código com chamada por nome:

```scala
def repeatMessage(times: Int, message: => String): Unit = {
  for (i <- 1 to times) {
    println(s"$i: ${message}")
  }
}

def expensiveMessage(): String = {
  println("Gerando mensagem...")
  Thread.sleep(100)
  "Olá mundo!"
}

repeatMessage(3, expensiveMessage())
```

Quantas vezes "Gerando mensagem..." será impresso?

**Escolha uma opção:**

- [ ] a. Depende da implementação do compilador
- [x] b. Três vezes - o argumento é reavaliado a cada referência no loop
- [ ] c. Uma vez - o argumento é avaliado apenas na primeira referência
- [ ] d. Nenhuma vez - o argumento nunca é usado
- [ ] e. Duas vezes - primeira e última iteração

---

## Questão 15

Sobre a implementação de chamada por nome usando thunks, assinale as alternativas corretas:

**Escolha uma ou mais:**

- [x] a. Scala permite a sintaxe `x: => Int` para parâmetros de chamada por nome.
- [x] b. Thunks são funções anônimas sem parâmetros que encapsulam uma expressão.
- [x] c. Argumentos são avaliados sempre que referenciados no corpo da função.
- [ ] d. Thunks são sempre mais eficientes que chamada por valor.
- [ ] e. Thunks só podem ser usados com tipos primitivos.

---

## Questão 16

Considere o seguinte código que mistura chamada por nome e por necessidade:

```scala
def mixedEvaluation(x: => Int): Int = {
  println("Função mixedEvaluation iniciada")
  lazy val y = x

  y + y + x
}

def computation(): Int = {
  println("Executando computation()")
  10
}

println("=== Chamando mixedEvaluation ===")
val result = mixedEvaluation(computation())
println(s"Resultado: $result")
```

Quantas vezes "Executando computation()" será impresso?

**Escolha uma opção:**

- [ ] a. Nenhuma vez - a função nunca avalia o argumento
- [ ] b. Quatro vezes - incluindo a definição do lazy val
- [ ] c. Três vezes - uma para cada referência na expressão
- [ ] d. Uma vez - todas as referências usam o cache
- [x] e. Duas vezes - uma para o cache, uma para a referência direta

---

## Questão 17

Considere o seguinte código:

```scala
def expensiveOperation(x: Int): Int = {
  println(s"Processing $x")
  x * x * x
}

def process(flag: Boolean, compute: => Int, fallback: Int): Int = {
  flag match {
    case true =>
      println("Branch A")
      compute * compute + fallback
    case false =>
      println("Branch B")
      fallback * fallback + compute
  }
}

process(true, expensiveOperation(5), 100)
// Branch A -> Processing 5 -> Processing 5
process(false, expensiveOperation(7), 200)
// Branch B -> Processing 7
```

Qual a sequência de impressões do programa?

**Escolha uma opção:**

- [x] a. "Branch A", "Processing 5", "Processing 5", "Branch B", "Processing 7"
- [ ] b. "Processing 5", "Processing 5", "Branch A", "Branch B", "Processing 7"
- [ ] c. "Branch A", "Processing 5", "Processing 7", "Branch B"
- [ ] d. "Branch A", "Branch B", "Processing 5", "Processing 7"
- [ ] e. "Branch A", "Processing 5", "Branch B", "Processing 7"

---

## Questão 18

Considere o seguinte código:

```scala
def triangular(): LazyList[Int] = {
  def tri(n: Int): LazyList[Int] = {
    val value = n * (n + 1) / 2
    println(s"Calculando triangular: $value")
    value #:: tri(n + 1)
  }
  tri(1)
}

val triSequence = triangular()
println("Sequência triangular criada")

val evenTris = triSequence.filter(_ % 2 == 0)
println("Filtro aplicado")

println(s"Primeiros 3 Triangulares pares: ${evenTris.take(3).toList}")
```

Quantas vezes "Calculando triangular:" será impresso?

**Escolha uma opção:**

- [ ] a. Nenhum - o filtro impede a avaliação
- [ ] b. Infinitos - a sequência é infinita
- [ ] c. Exatamente 3 - apenas os números pares encontrados
- [ ] d. Exatamente 6 - o dobro dos números solicitados
- [x] e. Mais de 3 - precisa calcular números ímpares também para encontrar os pares

---

## Questão 19

Considere o seguinte código em Scala:

```scala
def powers(base: Int, exp: Int = 1): LazyList[Int] = {
  val result = math.pow(base, exp).toInt
  println(s"Calculando $base^$exp = $result")
  result #:: powers(base, exp + 1)
}

val powersOf2 = powers(2)
println("Lista de potências criada")

println(s"2^1 = ${powersOf2.head}")
println(s"2^2 = ${powersOf2.tail.head}")

println(s"2^4 = ${powersOf2(3)}") // Índice 3 = 4º elemento

println(s"2^2 novamente = ${powersOf2.tail.head}")
```

Quantas mensagens do tipo "Calculando..." serão impressas no total?

**Escolha uma opção:**

- [ ] a. 6 mensagens - duas vezes para cada elemento acessado
- [ ] b. 5 mensagens - incluindo recálculo do elemento repetido
- [x] c. 4 mensagens - uma para cada potência calculada
- [ ] d. 7 mensagens - incluindo todos os elementos intermediários para chegar ao 4º
- [ ] e. 3 mensagens - apenas para os elementos únicos acessados

---

## Questão 20

Considere o seguinte código:

```scala
def build(n: Int = 1): LazyList[Int] = {
  println(s"Processando: $n")
  (n * 2 - 1) #:: build(n + 1)
}

def process(list: LazyList[Int]): Int = {
  if (list.isEmpty) 0
  else if (list.head % 2 == 0) list.head
  else process(list.tail)
}

val data = build()
println("Estrutura criada")
println(s"Resultado: ${process(data)}")
```

O que acontece quando este código é executado?

**Escolha uma opção:**

- [x] a. O programa entra em recursão infinita imprimindo "Processando:" indefinidamente
- [ ] b. O programa imprime apenas "Estrutura criada" e "Resultado: 0"
- [ ] c. O programa imprime "Processando: 1" e termina com "Resultado: 1"
- [ ] d. O programa imprime "Processando: 1", "Processando: 2" e termina com "Resultado: 2"
- [ ] e. O programa lança uma exceção de stack overflow imediatamente
