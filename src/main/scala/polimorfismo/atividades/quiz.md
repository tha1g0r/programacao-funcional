
# Atividade 8.1 — Polimorfismo

## Questão 1

Considere a seguinte função de composição genérica definida em Scala 3:

```scala
def compor[A, B, C](f: B => C, g: A => B): A => C =
  x => f(g(x))
```

Qual das seguintes afirmações sobre a função `compor` é **incorreta**?

- [ ] a. O resultado da aplicação `compor(f, g)` é uma nova função com a assinatura `A => C`.
- [x] b. A função `compor` causará erro de compilação se for chamada com funções sobre tipos primitivos como `Int => Double` e `Double => String`.
- [ ] c. `compor` emprega polimorfismo paramétrico com três parâmetros de tipo: `A`, `B` e `C`.
- [ ] d. A ordem de avaliação interna garante que a função `g` é aplicada primeiro sobre o argumento de tipo `A`, gerando um valor intermediário de tipo `B`.
- [ ] e. A implementação de `compor` é parametricamente uniforme, pois não depende dos tipos concretos que substituirão `A`, `B` ou `C`.

---

## Questão 2

Considere o seguinte método genérico em Scala 3:

```scala
def primeiroOuPadrao[A](xs: List[A], padrao: A): A =
  xs.headOption.getOrElse(padrao)
```

Analise as duas chamadas a seguir:

```scala
val r1 = primeiroOuPadrao(List(1, 2, 3), 0)
val r2 = primeiroOuPadrao(List("a", "b"), 10)
```

Qual alternativa descreve corretamente o resultado da compilação e os tipos inferidos para `r1` e `r2`?

- [ ] a. `r1` compila com tipo `Int`; `r2` gera erro de compilação porque `List[String]` e `Int` são tipos incompatíveis.
- [x] b. `r1` compila com o tipo `Int` (com valor `1`); `r2` compila com o tipo de união `String | Int` (com valor `"a"`), pois o compilador de Scala 3 infere o parâmetro de tipo `A` como o tipo união dos tipos dos argumentos.
- [ ] c. `r2` compila com tipo `String`, mas lança uma `ClassCastException` em tempo de execução.
- [ ] d. `r1` compila com tipo `Any`; `r2` compila com tipo `String`, descartando silenciosamente o argumento `10`.
- [ ] e. Ambas as chamadas causam erro de compilação por inconsistência de tipos.

---

## Questão 3

Considere a seguinte hierarquia de classes e a função `realizarSaque` em Scala 3:

```scala
trait Conta:
  def saldo: Double
  def sacar(valor: Double): Conta

class ContaCorrente(val saldo: Double) extends Conta:
  def sacar(valor: Double): ContaCorrente =
    ContaCorrente(saldo - valor)

class ContaInvestimento(val saldo: Double) extends Conta:
  def sacar(valor: Double): ContaInvestimento =
    if valor > 1000 then
      throw UnsupportedOperationException("Limite excedido")
    else
      ContaInvestimento(saldo - valor)

def realizarSaque(c: Conta, valor: Double): Conta =
  c.sacar(valor)
```

Ao passar uma instância de `ContaInvestimento` para a função `realizarSaque`, qual das seguintes análises explica corretamente o comportamento do código em relação à subtipagem e ao Princípio de Substituição de Liskov (LSP)?

- [x] a. `ContaInvestimento` viola a substituição transparente de subtipo porque lança uma exceção em tempo de execução para saques acima de 1000, quebrando o comportamento esperado pela função `realizarSaque` para uma `Conta` genérica.
> O Princípio de Substituição de Liskov exige que um subtipo possa substituir sua classe base sem alterar a corretude do programa. Ao introduzir uma restrição com exceção de runtime não prevista no contrato da trait `Conta`, a classe `ContaInvestimento` quebra o comportamento esperado pelo cliente que chama `realizarSaque`.
- [ ] b. A classe `ContaInvestimento` não compila porque traits em Scala 3 só podem ser estendidas por `case class`.
- [ ] c. A substituição de `Conta` por `ContaInvestimento` é plenamente transparente e segura, pois exceções lançadas em tempo de execução são capturadas e corrigidas pelo compilador.
- [ ] d. O código falha na compilação porque a classe `ContaInvestimento` retorna `ContaInvestimento` no método `sacar`, o que é incompatível com o tipo de retorno `Conta` definido na trait.
- [ ] e. O código falha na compilação porque a função `realizarSaque` exige obrigatoriamente que o argumento `c` seja do tipo `ContaCorrente`.

---

## Questão 4

Considere as seguintes declarações em Scala 3 que utilizam a hierarquia unificada de tipos:

```scala
val x: AnyVal = 42
val y: AnyRef = "Scala"
val z = if true then x else y
val w: String = null
```

Qual das seguintes análises é correta a respeito dos tipos e da compilação desse código?

- [x] a. O código compila com sucesso, e o tipo inferido pelo compilador para a variável `z` é o menor supertipo comum (Least Upper Bound), que é `Any` (ou `Matchable`).
- [ ] b. O tipo da variável `x` é inferido como `Nothing` porque `42` é um literal primitivo.
- [ ] c. O código falha na compilação na linha de `z`, pois `x` e `y` pertencem aos ramos disjuntos `AnyVal` e `AnyRef`.
- [ ] d. O código falha na compilação na linha de `w`, pois o valor `null` não pode ser atribuído a variáveis do tipo `String`.
- [ ] e. O tipo de `z` é inferido como `AnyRef` porque `String` tem precedência sobre tipos numéricos.

---

## Questão 5

Considere a utilização do singleton `Nil`, que representa a lista vazia imutável em Scala, nas seguintes atribuições:

```scala
val xs: List[Int] = Nil
val ys: List[String] = Nil
```

Sabendo que `Nil` é definido formalmente como um objeto do tipo `List[Nothing]`, por que a linguagem permite atribuir a mesma instância `Nil` a variáveis dos tipos `List[Int]` e `List[String]` sem erro de tipo?

- [ ] a. Porque `Nothing` é um alias para `Any`, o que faz com que `List[Nothing]` seja equivalente a `List[Any]`.
- [x] b. Porque `List` é um construtor de tipo covariante (`List[+A]`) e `Nothing` é o tipo bottom (subtipo de todos os tipos), tornando `List[Nothing]` um subtipo de `List[T]` para qualquer tipo `T`.
- [ ] c. Porque a classe `List` em Scala é contravariante, invertendo a relação de subtipagem da hierarquia.
- [ ] d. Porque `Nil` é um método genérico que recebe um parâmetro de tipo implícito em tempo de execução.
- [ ] e. Porque o compilador faz uma coerção implícita que aloca um novo objeto `List[Int]` ou `List[String]` a cada atribuição.

---

## Questão 6

Considere o seguinte trecho de código em Scala 3 que define e utiliza uma Type Class:

```scala
trait Show[A]:
  def show(a: A): String

given Show[Int] with
  def show(a: Int): String = s"Numero: $a"

def exibir[A](valor: A)(using s: Show[A]): String =
  s.show(valor)
```

Assinale a alternativa correta sobre esse código:

- [ ] a. A palavra-chave `given` altera diretamente o bytecode de `java.lang.Integer` em tempo de compilação.
- [ ] b. O método `exibir` só poderá ser executado se o argumento `valor` for uma instância de `String`.
- [ ] c. O código falha na compilação porque o tipo primitivo `Int` não pode ter instâncias de Type Class associadas.
- [x] d. A cláusula `(using s: Show[A])` permite ao compilador encontrar e injetar automaticamente a instância `given Show[Int]` ao invocar `exibir(42)`, dispensando a passagem explícita do segundo argumento.
- [ ] e. `Show[A]` impõe uma relação de subtipagem orientada a objetos tradicional, fazendo com que a classe `Int` herde diretamente de `Show`.

---

## Questão 7

Em Scala 3, a assinatura de uma função que exige uma Type Class pode ser simplificada utilizando a sintaxe de context bound:

```scala
def duplicar[A : Show](valor: A): String = ???
```

Essa declaração usando `[A : Show]` é um açúcar sintático para qual das seguintes assinaturas equivalentes?

- [ ] a. `def duplicar[A >: Show[A]](valor: A): String`
- [x] b. `def duplicar[A](valor: A)(using Show[A]): String`
> O *Context Bound* `[A : Show]` desaçucara exatamente para a inclusão de um segundo grupo de parâmetros contextuais marcados com `using Show[A]` (ou `(implicit s: Show[A])` em Scala 2).
- [ ] c. `def duplicar[A <: Show[A]](valor: A): String`
- [ ] d. `def duplicar(valor: Show[Any]): String`
- [ ] e. `def duplicar[A](valor: Show[A]): String`

---

## Questão 8

Considere a seguinte definição de Type Class de igualdade (`Eq`) combinada com um bloco de métodos de extensão (`extension`) em Scala 3:

```scala
trait Eq[A]:
  def eqv(x: A, y: A): Boolean

extension [A](x: A)(using eqInst: Eq[A])
  def ===(y: A): Boolean = eqInst.eqv(x, y)
```

Assumindo que exista uma instância `given Eq[Int]` disponível no escopo, qual é o resultado direto da declaração de `extension` acima?

- [ ] a. Provoca um erro de compilação, pois identificadores de método em Scala não podem conter o caractere `=`.
- [ ] b. Sobrescreve o método de igualdade padrão `==` de todas as classes da JVM.
- [ ] c. Altera a classe original `java.lang.Integer` injetando nela o método `===` via reflexão em tempo de execução.
- [x] d. Permite utilizar a sintaxe infixa amigável `1 === 2` para comparar valores de qualquer tipo `A` que possua uma instância de `Eq[A]` no escopo contextual.
- [ ] e. Força a conversão do inteiro `1` em um valor booleano antes da comparação.

---

## Questão 9

Em Scala, o tipo de função `Function1[-A, +B]` (sintaxe `A => B`) é contravariante no argumento `A` e covariante no resultado `B`. Considere a hierarquia de tipos em que:

```text
Angora <: Gato <: Animal
```

> `Function1[-A, +B]` significa que ao atribuir uma função concreta a um tipo `X => Y`, a função concreta pode ter:
> - um parâmetro **mais amplo** (ou igual) que `X` — porque é contravariante em `A`
> - um parâmetro **mais específico** (ou igual) que `Y` — porque é covariante em `B`

Qual das seguintes declarações e atribuições de função compila sem erros respeitando as regras de variância de funções?

- [x] a. `val f: Gato => Gato = (a: Animal) => new Angora()`
- [ ] b. `val f: Angora => Animal = (a: Animal) => new Angora()`
- [ ] c. `val f: Gato => Angora = (g: Gato) => new Animal()`
- [ ] d. `val f: Gato => Gato = (g: Angora) => new Animal()`
- [ ] e. `val f: Animal => Angora = (g: Gato) => new Gato()`

---

## Questão 10

Considere a seguinte tentativa de compilação de uma trait imutável genérica em Scala:

```scala
trait Pilha[+A]:
  def empilhar(elem: A): Pilha[A]
```

Por que o compilador do Scala rejeita esse código emitindo um erro de compilação?

- [x] a. Porque o parâmetro de tipo covariante `+A` foi utilizado como tipo do argumento `elem`, que é uma posição contravariante (posição de entrada de método), violando a segurança de tipos.
- [ ] b. Porque o nome `Pilha` é uma palavra reservada da linguagem Scala.
- [ ] c. Porque o tipo de retorno `Pilha[A]` deveria ser substituído por `AnyRef`.
- [ ] d. Porque a trait `Pilha` deveria ser anotada obrigatoriamente como contravariante `[-A]`.
- [ ] e. Porque traits em Scala não suportam a declaração de métodos com parâmetros.

---

## Questão 11

Analise o seguinte código em Scala 3:

```scala
trait Exibivel:
  def exibir(): String

case class Item(nome: String) extends Exibivel:
  def exibir(): String = nome

def imprimirTodos[A <: Exibivel](lista: List[A]): Unit =
  lista.foreach(x => println(x.exibir()))
```

Qual é a função e o objetivo da anotação `[A <: Exibivel]` na assinatura da função `imprimirTodos`?

- [ ] a. Forçar uma coerção implícita de qualquer tipo `A` para a classe concreta `Item`.
- [ ] b. Permitir que a função seja chamada apenas passando a lista vazia `List[Nothing]`.
- [ ] c. Definir um limite inferior (Lower Bound), permitindo passar qualquer supertipo de `Exibivel` como parâmetro de tipo `A`.
- [ ] d. Indicar que a função `imprimirTodos` é contravariante em relação ao parâmetro de tipo `A`.
- [x] e. Definir um limite superior (Upper Bound), restringindo o parâmetro `A` para ser `Exibivel` ou qualquer um de seus subtipos, garantindo que o método `exibir()` existe em `x`.

---

## Questão 12

Para corrigir a trait covariante `Pilha[+A]` mantendo a segurança de tipos, utiliza-se um limite inferior (Lower Bound) no método de inserção:

```scala
trait Pilha[+A]:
  def empilhar[B >: A](elem: B): Pilha[B]
```

Dadas as classes `Gato <: Animal`, suponha que tenhamos uma lista/pilha inicial do tipo `p1: Pilha[Gato]`.

Se executarmos a chamada:

```scala
val p2 = p1.empilhar(new Animal())
```

qual será o tipo estático da pilha `p2` inferido pelo compilador?

- [ ] a. O código falha na compilação porque não é possível inserir um supertipo em uma pilha de um subtipo.
- [ ] b. `Pilha[AnyVal]`, pois a chamada força a conversão para tipo de valor.
- [ ] c. `Pilha[Nothing]`, pois ao misturar tipos a pilha é esvaziada.
- [x] d. `Pilha[Animal]`, pois o parâmetro de tipo `B` é inferido como `Animal`, o ancestral comum, generalizando com segurança o tipo da nova pilha resultante.
- [ ] e. `Pilha[Gato]`, pois o novo elemento `Animal` é convertido automaticamente para `Gato`.

---

## Questão 13

O polimorfismo paramétrico permite definir funções e abstrações de dados que operam de forma idêntica sobre diferentes tipos.

Qual é uma propriedade fundamental do polimorfismo paramétrico puro, sem restrições de bounds ou type classes?

- [ ] a. A função tem acesso nativo a operadores aritméticos como `+` e `*` sobre qualquer tipo genérico `A`.
- [ ] b. O compilador é obrigado a monomorfizar a função, gerando cópias físicas do código para cada tipo usado no programa.
- [ ] c. O uso de parâmetros de tipo exige obrigatoriamente que todos os tipos envolvidos herdem de uma classe base comum.
- [ ] d. A função genérica pode inspecionar os membros internos do tipo genérico em tempo de execução via reflexão sem qualquer restrição de compilação.
- [x] e. A função trata os valores do tipo paramétrico de forma completamente opaca (parametricity), executando exatamente a mesma lógica independentemente do tipo concreto fornecido.

---

## Questão 14

Devido à arquitetura da JVM, o Scala adota o mecanismo de Type Erasure (apagamento de tipos) para implementar o polimorfismo paramétrico.

Qual é uma consequência direta desse mecanismo em tempo de execução (runtime)?

- [ ] a. Todas as coleções genéricas são automaticamente convertidas para estruturas mutáveis em tempo de execução.
- [ ] b. O compilador é obrigado a gerar cópias físicas separadas do bytecode para cada tipo concreto utilizado (monomorfização).
- [ ] c. O uso de parâmetros de tipo desativa a verificação estática de tipos realizada pelo compilador.
- [ ] d. É impossível declarar classes genéricas com mais de um parâmetro de tipo, como `Map[K, V]`.
- [x] e. As informações sobre os parâmetros de tipo genéricos, como o tipo dos elementos de uma `List[T]`, são removidas após a compilação, fazendo com que a JVM enxergue apenas o tipo bruto (raw type) em tempo de execução.

---

## Questão 15

Assinale a alternativa que estabelece uma comparação correta entre o polimorfismo paramétrico:

```scala
def proc[A](x: A): A
```

e o polimorfismo de subtipo por herança:

```scala
def proc(x: ElementoBase): ElementoBase
```

- [ ] a. O polimorfismo de subtipo é verificado exclusivamente em tempo de compilação, enquanto o paramétrico requer resolução dinâmica de tipos em tempo de execução.
- [x] b. O polimorfismo paramétrico preserva a informação exata do tipo concreto original tanto na entrada quanto no retorno da função, enquanto o polimorfismo de subtipo reduz a informação do tipo de retorno ao tipo ancestral comum.
- [ ] c. O polimorfismo de subtipo impede a realização de dispatch dinâmico de métodos.
- [ ] d. O polimorfismo paramétrico exige a alteração do código-fonte da classe original para adicionar cláusulas de herança.
- [ ] e. O polimorfismo paramétrico é restrito a tipos primitivos numéricos.

---

## Questão 16

Em Scala 3, a hierarquia de tipos possui uma estrutura unificada encabeçada por `Any` e finalizada por `Nothing`.

Qual das seguintes afirmações sobre o tipo `Nothing` e a hierarquia de subtipagem é a única correta?

- [x] a. `Nothing` é subtipo de absolutamente todos os tipos em Scala, permitindo seu uso como valor de retorno em expressões que lançam exceções ou não terminam.
- [ ] b. `Any` é subtipo de `AnyRef`, que por sua vez é subtipo de `Nothing`.
- [ ] c. `Nothing` possui exatamente uma instância em tempo de execução, que é a palavra-chave `null`.
- [ ] d. `Null` é subtipo de `AnyVal` e de `AnyRef`, mas não é subtipo de `Any`.
- [ ] e. `Nothing` é supertipo de todos os tipos de valor (`AnyVal`), mas não de tipos de referência (`AnyRef`).

---

## Questão 17

Na teoria das linguagens de programação, distingue-se o polimorfismo de subtipo (inclusão) do polimorfismo por coerção (conversão implícita/explícita).

Qual é a diferença fundamental entre esses dois mecanismos?

- [ ] a. O polimorfismo de subtipo é exclusivo de linguagens sem verificação estática de tipos.
- [ ] b. A coerção é decidida estritamente em tempo de execução via dispatch dinâmico, enquanto a subtipagem é resolvida em tempo de compilação.
- [ ] c. O polimorfismo de subtipo altera fisicamente o arranjo de memória do objeto, enquanto a coerção mantém a referência original intacta.
- [x] d. O polimorfismo de subtipo baseia-se em uma relação de inclusão de conjuntos/hierarquia onde o valor não é alterado, enquanto a coerção envolve a transformação semântica de um valor de um tipo em um valor de outro tipo.
- [ ] e. Não há diferença conceitual ou prática; ambos são termos sinônimos para a mesma construção na teoria dos tipos.

---

## Questão 18

O polimorfismo ad-hoc permite aplicar uma mesma interface ou nome de função a tipos diferentes sem exigir que esses tipos compartilhem uma classe base comum na hierarquia de herança.

Em linguagens puramente funcionais e em Scala 3, qual mecanismo é utilizado para implementar o polimorfismo ad-hoc de forma desacoplada e estaticamente segura, resolvendo as duas dimensões do problema da expressão?

- [x] a. Type Classes (Classes de Tipos).
- [ ] b. Herança múltipla de classes concretas.
- [ ] c. Declaração de métodos estáticos em objetos globais sem parâmetros de tipo.
- [ ] d. Coerção forçada usando castings de tipo como `asInstanceOf`.
- [ ] e. Sobrecarga de funções (function overloading) resolvida em tempo de compilação pelo compilador.

---

## Questão 19

Na engenharia de software funcional, destaca-se a capacidade das Type Classes de realizarem a chamada "extensão retroativa" (retroactive extension ou retroactive modeling).

O que significa essa propriedade em comparação ao polimorfismo de subtipos tradicional baseado em herança?

- [ ] a. A capacidade de estender tipos desativando a verificação de segurança do compilador durante a execução.
- [ ] b. A exigência de que todos os métodos genéricos voltem a ser estaticamente sobrescritos por sub-classes.
- [ ] c. A capacidade de descompilar o código e gerar classes C++ em tempo de execução.
- [x] d. A capacidade de adicionar novas funcionalidades e comportamentos a tipos pré-existentes, como `Int`, `String` ou classes de bibliotecas de terceiros, sem modificar seu código-fonte nem alterar suas hierarquias de herança.
- [ ] e. A capacidade de alterar o código de bibliotecas compiladas em arquivos JAR em tempo de execução via bytecode weaving.

---

## Questão 20

Considere duas classes em uma relação de subtipagem onde:

```text
Gato <: Animal
```

Seja `F` um construtor de tipo paramétrico.

Qual das seguintes definições sobre as anotações de variância em Scala é a única correta?

- [x] a. Se `F[+A]` é covariante, então `F[Gato] <: F[Animal]`; se `F[-A]` é contravariante, então `F[Animal] <: F[Gato]`; se `F[A]` é invariante, não há relação de subtipagem entre `F[Gato]` e `F[Animal]`.
- [ ] b. Variância é um conceito aplicável apenas a tipos primitivos numéricos e não a construtores de tipo genéricos.
- [ ] c. Se `F[+A]`, então `F[Animal] <: F[Gato]`; se `F[-A]`, então `F[Gato] <: F[Animal]`.
- [ ] d. Se `F[A]` é invariante, então `F[Gato]` e `F[Animal]` são tipos idênticos em tempo de compilação.
- [ ] e. A anotação `[+A]` estabelece contravariância e `[-A]` estabelece covariância.
