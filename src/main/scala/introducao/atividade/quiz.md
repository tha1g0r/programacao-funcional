# Quiz — Atividade 01: Fundamentos de programação funcional

> Marque as alternativas que você escolher. Nas questões de múltipla seleção, pode haver mais de uma resposta correta.

## Questão 1

Considere o código abaixo:

```java
Function<Integer, Integer> f = x -> x * 2; // recebe: int; retorna: int
int y = f.apply(10);
```

O valor de `y` será:

* [ ] **a.** 100
* [ ] **b.** 5
* [x] **c.** 20
* [ ] **d.** 10
* [ ] **e.** 12

---

## Questão 2

Qual das opções abaixo define corretamente uma função de ordem superior em Java?

* [x] **a.**

  ```java
  public static <T> T applyTwice(Function<T, T> func, T value) {
      return func.apply(func.apply(value));
  }
  ```
* [ ] **b.**

  ```java
  List<String> words = Arrays.asList("java", "python", "scala");
  words.stream().map(String::toUpperCase).collect(Collectors.toList());
  ```
* [ ] **c.** Nenhuma das anteriores
* [ ] **d.**

  ```java
  int square(int x) {
      return x * x;
  }
  ```
* [ ] **e.**

  ```java
  Function<Integer, Integer> f = x -> x + 1;
  ```

---

## Questão 3

O que acontece ao tentar compilar o seguinte código?

```java
Function<Integer, Integer> f = (x, y) -> x + y;
// I: int; O: int         | I: (int, int); O: int
```

* [ ] **a.** Erro de compilação: operador `+` não é sobrecarregado para `Integer`.
* [ ] **b.** Compila normalmente.
* [x] **c.** Erro de tipo: a interface espera apenas um argumento.
* [ ] **d.** O código executa, mas retorna `null`.
* [ ] **e.** Erro de sintaxe: lambdas não são suportadas.

---

## Questão 4

Analise o trecho de código abaixo:

```java
int x = 5;
x = x + 1;
System.out.println(x);
```

Esse código é um exemplo de qual paradigma?

* [ ] **a.** Orientado a objetos
* [ ] **b.** Funcional
* [ ] **c.** Declarativo puro
* [x] **d.** Imperativo
* [ ] **e.** Lógico

---

## Questão 5

Sobre funções de ordem superior, assinale a alternativa correta:

* [ ] **a.** São funções que não podem ser armazenadas em variáveis.
* [ ] **b.** São funções que obrigatoriamente devem ser recursivas.
* [x] **c.** São funções que recebem outras funções como argumentos e/ou retornam funções como resultado.
* [ ] **d.** São funções que só podem receber funções como argumentos.
* [ ] **e.** São funções que não podem apresentar efeitos colaterais.

---

## Questão 6

O que significa dizer que funções são de primeira classe em uma linguagem de programação?

* [ ] **a.** Funções não podem ser passadas como parâmetros.
* [ ] **b.** Funções devem ser declaradas antes de todas as outras instruções no código.
* [ ] **c.** Funções só podem ser usadas como métodos estáticos.
* [x] **d.** Funções podem ser atribuídas a variáveis, passadas como argumentos e retornadas por outras funções.
* [ ] **e.** Funções não podem ser armazenadas em estruturas de dados.

---

## Questão 7

O cálculo lambda, que é a base teórica da programação funcional, foi desenvolvido por:

* [ ] **a.** Alan Turing
* [ ] **b.** Donald Knuth
* [ ] **c.** Edsger Dijkstra
* [x] **d.** Alonzo Church
* [ ] **e.** John McCarthy

---

## Questão 8

Qual das opções abaixo representa um conceito introduzido por linguagens funcionais e que posteriormente foi incorporado à linguagem Java?

* [x] **a.** Funções anônimas (lambdas)
* [ ] **b.** Saltos condicionais (`Goto`)
* [ ] **c.** Herança múltipla de implementação
* [ ] **d.** Sobrecarga de operadores
* [ ] **e.** Uso de ponteiros explícitos

---

## Questão 9

Sobre a relação entre tendências tecnológicas recentes e a popularização da programação funcional, assinale a alternativa correta:

* [ ] **a.** A programação funcional é pouco utilizada na computação em nuvem e nos sistemas distribuídos.
* [ ] **b.** O paradigma funcional é utilizado apenas em aplicações acadêmicas, tendo pouca relação com tendências atuais de desenvolvimento de software comercial.
* [ ] **c.** Machine learning e big data são incompatíveis com programação funcional.
* [x] **d.** O crescimento de aplicações em big data e machine learning favoreceu o uso de programação funcional devido à necessidade de processamento concorrente na manipulação de grandes volumes de dados.
* [ ] **e.** O paradigma funcional perdeu relevância com o surgimento de big data e machine learning.

---

## Questão 10

Qual característica da programação funcional é especialmente vantajosa em aplicações de big data e machine learning?

* [ ] **a.** Mutabilidade do espaço de memória do programa.
* [ ] **b.** Uso intensivo de variáveis globais mutáveis.
* [x] **c.** Facilidade de paralelização e ausência de efeitos colaterais.
* [ ] **d.** Necessidade de gerenciamento manual de recursos de sistema.
* [ ] **e.** Dependência de comandos sequenciais.

---

## Questão 11

Por que linguagens funcionais como Scala e Clojure ganharam destaque em tarefas que envolvem processamento de grandes volumes de dados?

* [ ] **a.** Porque não possuem suporte a programação orientada a objetos.
* [ ] **b.** Porque possuem melhor desempenho em operações de entrada e saída de dados.
* [ ] **c.** Porque são as únicas linguagens que conseguem efetuar esses processamentos.
* [ ] **d.** Porque os desenvolvedores dessa área recusam-se a usar outras linguagens.
* [x] **e.** Porque facilitam a programação concorrente e a manipulação de dados imutáveis, essenciais para o processamento distribuído.

---

## Questão 12

Qual das alternativas melhor define imutabilidade em programação funcional?

* [x] **a.** Dados, uma vez criados, não podem ser modificados; alterações geram novas versões dos dados.
* [ ] **b.** Funções podem modificar qualquer valor.
* [ ] **c.** Dados são armazenados em estruturas que permitem acesso de escrita irrestrito.
* [ ] **d.** Variáveis globais são preferidas.
* [ ] **e.** Dados podem ser alterados livremente após a criação.

---

## Questão 13

Considere o código:

```java
final int x = 10;
// x = 20; // linha comentada
```

O que acontece se a linha comentada for descomentada?

* [ ] **a.** O código compila normalmente.
* [ ] **b.** O valor de `x` é copiado para uma nova variável com valor 20.
* [x] **c.** O compilador gera um erro, pois `x` é imutável.
* [ ] **d.** O valor de `x` é alterado apenas em tempo de execução.
* [ ] **e.** O valor de `x` passa a ser 20.

---

## Questão 14

Sobre as vantagens da imutabilidade em programação funcional, assinale a alternativa correta:

* [ ] **a.** Dificulta a criação de funções puras.
* [ ] **b.** Reduz significativamente o desempenho do programa.
* [ ] **c.** Aumenta a dependência de variáveis globais.
* [x] **d.** Torna o código mais previsível e seguro para concorrência.
* [ ] **e.** Facilita a ocorrência de efeitos colaterais.

---

## Questão 15

Qual das alternativas abaixo representa uma desvantagem do uso exclusivo de imutabilidade?

* [ ] **a.** Facilita a ocorrência de condições de corrida em programas concorrentes.
* [ ] **b.** Torna o código menos modular.
* [x] **c.** Pode aumentar o consumo de memória devido à criação de novas versões dos dados.
* [ ] **d.** Dificulta a testabilidade do código.
* [ ] **e.** Impede completamente a implementação de algoritmos recursivos.

---

## Questão 16

Sobre a mutabilidade, assinale a alternativa correta:

* [ ] **a.** Facilita o controle de estados em programas concorrentes.
* [ ] **b.** É obrigatória em linguagens funcionais puras.
* [ ] **c.** Garante ausência de efeitos colaterais.
* [x] **d.** Pode levar a efeitos colaterais e tornar o código mais difícil de manter.
* [ ] **e.** Sempre melhora o desempenho do programa.

---

## Questão 17

Qual das alternativas é uma vantagem do uso de dados mutáveis?

* [x] **a.** Possibilidade de otimizações de desempenho em cenários específicos.
* [ ] **b.** Simplificação automática do gerenciamento de memória.
* [ ] **c.** Garantia de previsibilidade do estado dos dados.
* [ ] **d.** Eliminação de efeitos colaterais.
* [ ] **e.** Facilidade de paralelização sem sincronização.

---

## Questão 18

Sobre interfaces funcionais em Java, assinale a alternativa correta:

* [ ] **a.** Não podem ser usadas com tipos genéricos.
* [x] **b.** Devem possuir apenas um método abstrato.
* [ ] **c.** Devem possuir exatamente dois métodos abstratos.
* [ ] **d.** São opcionais para a tipagem de lambdas em Java.
* [ ] **e.** Devem implementar obrigatoriamente a interface `Serializable`.

---

## Questão 19

O que caracteriza a programação funcional em relação a outros paradigmas?

* [ ] **a.** Manipulação direta de memória
* [x] **b.** Definição, aplicação e composição de funções puras, evitando estados mutáveis e efeitos colaterais
* [ ] **c.** Uso intensivo de variáveis globais
* [ ] **d.** Dependência exclusiva de herança de classes
* [ ] **e.** Controle explícito de fluxo com comandos

---

## Questão 20

Qual das alternativas abaixo **NÃO** é uma característica típica da programação funcional?

* [ ] **a.** Funções puras
* [x] **b.** Uso extensivo de laços de repetição
* [ ] **c.** Composição de funções
* [ ] **d.** Imutabilidade dos dados
* [ ] **e.** Uso de recursão em vez de iteração

---

## Questão 21

Sobre paradigmas de programação, assinale a alternativa correta:

* [ ] **a.** Paradigmas de programação são restritos à programação orientada a objetos.
* [ ] **b.** Paradigmas de programação determinam apenas a velocidade de execução dos programas.
* [x] **c.** Paradigmas de programação classificam linguagens segundo características fundamentais e estilos de resolução de problemas.
* [ ] **d.** Paradigmas de programação não influenciam a forma de pensar soluções.
* [ ] **e.** Paradigmas de programação são apenas aspectos de estilos de código, como indentação, espaçamento e convenções de nomenclatura.

---

## Questão 22

Qual das opções abaixo melhor descreve o paradigma imperativo?

* [ ] **a.** Computação baseada em funções matemáticas e imutabilidade.
* [ ] **b.** Computação centrada em abstração e encapsulamento de dados.
* [ ] **c.** Computação baseada em lógica formal e inferência.
* [ ] **d.** Computação baseada em consultas sobre dados tabulares.
* [x] **e.** Computação em termos de estados mutáveis e comandos sequenciais.

---

## Questão 23

Sobre linguagens funcionais puras, assinale a alternativa correta:

* [ ] **a.** Não suportam recursão.
* [ ] **b.** São sempre orientadas a objetos.
* [x] **c.** Não permitem a definição de programas que violem imutabilidade, ausência de efeitos colaterais e transparência referencial.
* [ ] **d.** Requerem compilação para linguagem de máquina para serem executadas.
* [ ] **e.** Permitem livremente efeitos colaterais e mutabilidade.

---

## Questão 24

Qual alternativa apresenta apenas linguagens consideradas funcionais puras?

* [x] **a.** Haskell, Elm, Idris
* [ ] **b.** Scala, F#, Kotlin
* [ ] **c.** JavaScript, TypeScript, Haskell
* [ ] **d.** C++, Elm, Rust
* [ ] **e.** Java, C#, Python

---

## Questão 25

Sobre linguagens funcionais híbridas, é correto afirmar:

* [ ] **a.** São prioritariamente imperativas (imperative-first).
* [x] **b.** Suportam programação funcional, mas permitem violar seus princípios.
* [ ] **c.** Não suportam programação funcional.
* [ ] **d.** Não suportam funções de ordem superior.
* [ ] **e.** Requerem sempre tipagem estática para funcionarem corretamente.

---

## Questão 26

**Assinale TODAS as alternativas que representam expressões em linguagens de programação:**

* [x] **a.** `Math.sqrt(16)`
* [x] **b.** `x > 0 ? x : -x`
* [ ] **c.** `while (true) { break; }`
* [ ] **d.** `if (x > 0) { y = x; }`
* [x] **e.** `2 + 2`

---

## Questão 27

**Assinale TODAS as alternativas que representam comandos (statements) em linguagens de programação:**

* [ ] **a.** `x == 0`
* [ ] **b.** `x * 10`
* [x] **c.** `int x = 5;`
* [x] **d.** `return y + 1;`
* [x] **e.** `for (int i = 0; i < 10; i++) { ... }`

---

## Questão 28

Considere a seguinte classe em Java:

```java
class Exemplo {
    int contador = 0;
    static final double PI = 3.141592653589793;

    int soma(int a, int b) { return a + b; }

    int multiplica(int x, int y) { return x * y; }

    void incrementa() { contador++; }

    void imprime(String msg) { System.out.println(msg); }

    int quadrado(int n) { return n * n; }

    int getContador() { return contador; }

    double areaCirculo(double raio) { return PI * raio * raio; }
}
```

**Assinale TODAS as alternativas que listam apenas métodos que podem ser considerados funções puras:**

* [ ] **a.** `soma, multiplica, getContador, areaCirculo`
* [ ] **b.** `soma, multiplica, quadrado, getContador`
* [ ] **c.** `soma, multiplica, quadrado, incrementa`
* [x] **d.** `soma, multiplica, quadrado, areaCirculo`
* [ ] **e.** `soma, multiplica, quadrado, imprime`

---

## Questão 29

Considere a seguinte classe Java:

```java
class Recursive {
    int somaLista(int[] arr, int idx) {
        if (idx == arr.length) return 0;
        return arr[idx] + somaLista(arr, idx + 1);
    }

    int produtoLista(int[] arr, int idx, int acc) {
        if (idx == arr.length) return acc;
        return produtoLista(arr, idx + 1, acc * arr[idx]);
    }

    int busca(int[] arr, int idx, int valor) {
        if (idx == arr.length) return -1;
        if (arr[idx] == valor) return idx;
        return busca(arr, idx + 1, valor);
    }

    int contaPares(int[] arr, int idx, int acc) {
        if (idx == arr.length) return acc;
        if (arr[idx] % 2 == 0)
            return contaPares(arr, idx + 1, acc + 1);
        else
            return contaPares(arr, idx + 1, acc);
    }

    int maximo(int[] arr, int idx) {
        if (idx == arr.length - 1) return arr[idx];
        int maxRestante = maximo(arr, idx + 1);
        return arr[idx] > maxRestante ? arr[idx] : maxRestante;
    }

    int somaQuadrados(int[] arr, int idx) {
        if (idx == arr.length) return 0;
        return arr[idx] * arr[idx] + somaQuadrados(arr, idx + 1);
    }
}
```

**Assinale TODAS as alternativas que listam apenas métodos da classe acima que são recursivos com chamada na cauda (recursão de cauda).**

Dica: basta analisar a posição da chamada recursiva conforme a definição de recursão de cauda.

* [x] **a.** `produtoLista, busca, contaPares`
* [ ] **b.** `produtoLista, contaPares` x
* [ ] **c.** `somaLista, produtoLista, busca, contaPares` x
* [ ] **d.** `produtoLista, busca, contaPares, somaQuadrados`x
* [ ] **e.** `produtoLista, busca, maximo` x

---

## Questão 30

**Assinale TODAS as alternativas que representam expressões que NÃO são referencialmente transparentes:**

* [x] **a.** `Math.random() * 10`
* [x] **b.** `System.currentTimeMillis()`
* [ ] **c.** `"abc".toUpperCase()`
* [ ] **d.** `Math.abs(-5)`
* [ ] **e.** `2 + 2`

---

## Questão 31

**Assinale TODAS as alternativas que apresentam exemplos de expressões referencialmente transparentes:**

* [x] **a.** `7 * (8 - 3)`
* [ ] **b.** `Locale.setDefault(Locale.US)`
* [x] **c.** `Math.max(4, 9)`
* [ ] **d.** `Math.random() + 1`
* [x] **e.** `"hello".substring(1, 3)`

---

## Questão 32

Sobre efeitos colaterais em funções, **assinale todas as alternativas corretas:**

* [x] **a.** Uma função que modifica o estado de um objeto passado como argumento gera efeito colateral.
* [x] **b.** Efeitos colaterais podem dificultar a depuração de programas.
* [x] **c.** Funções impuras podem produzir diferentes resultados mesmo com os mesmos argumentos.
* [ ] **d.** Funções puras sempre eliminam a necessidade de sincronização em programas paralelos.
* [ ] **e.** Funções puras podem compor resultados a partir de variáveis globais livremente.

---

## Questão 33

Qual das alternativas abaixo define corretamente o que é um efeito colateral em programação?

* [ ] **a.** Uma expressão só tem efeito colateral quando altera o valor que ela própria retorna.
* [ ] **b.** Qualquer operação cujo resultado dependa exclusivamente dos parâmetros recebidos, mesmo sem alterar estado interno ou externo.
* [ ] **c.** Apenas modificações em variáveis globais são efeitos colaterais; alterações em objetos recebidos por referência não contam.
* [x] **d.** Qualquer alteração observável no estado do programa ou no ambiente externo que não esteja representada apenas no valor de retorno da expressão.
* [ ] **e.** Somente operações de entrada/saída caracterizam efeitos colaterais; mudanças de estado em memória não entram nessa definição.

---

## Questão 34

**Assinale TODAS as alternativas que representam situações que são efeitos colaterais em programação:**

* [ ] **a.** Acessar uma constante definida fora da função.
* [ ] **b.** Calcular o quadrado de um número em função sem acessar variáveis externas.
* [x] **c.** Escrever uma mensagem em um arquivo de texto.
* [x] **d.** Modificar uma variável global dentro de uma função.
* [x] **e.** Uma função cujo resultado é o horário atual do sistema.

---

## Questão 35

Sobre os problemas causados pela presença de efeitos colaterais em programas, **assinale TODAS as alternativas corretas:**

* [ ] **a.** Garantem que o código seja sempre determinístico.
* [x] **b.** Dificultam a previsibilidade do comportamento do programa.
* [x] **c.** Podem introduzir defeitos (bugs) difíceis de reproduzir.
* [x] **d.** Podem tornar o teste e a depuração mais complexos.
* [ ] **e.** Não influenciam a composição e reutilização de funções.

---

## Questão 36

Sobre expressões e comandos, **assinale TODAS as alternativas corretas:**

* [x] **a.** Comandos podem alterar variáveis globais durante a execução.
* [x] **b.** Comandos podem não produzir valor e realizam ações imperativas.
* [x] **c.** Expressões podem ser usadas como argumentos em chamadas de função.
* [x] **d.** Tanto comandos quanto expressões podem gerar efeitos colaterais, dependendo do contexto.
* [ ] **e.** Toda expressão é sempre referencialmente transparente.

---

## Questão 37

Qual das alternativas abaixo define corretamente uma função pura?

* [ ] **a.** Uma função que utiliza apenas variáveis locais, mas pode modificar o estado interno de argumentos passados por referência.
* [x] **b.** Uma função que sempre retorna o mesmo resultado para os mesmos argumentos e não gera efeitos colaterais.
* [ ] **c.** Uma função que pode modificar variáveis globais, mas sempre retorna o mesmo valor.
* [ ] **d.** Uma função que chama outras funções impuras, mas não modifica variáveis globais diretamente.
* [ ] **e.** Uma função que realiza operações de entrada/saída e gera sempre o mesmo valor.

---

## Questão 38

Qual das opções abaixo **NÃO** é uma característica de uma função pura?

* [ ] **a.** Seu resultado depende apenas dos argumentos fornecidos.
* [ ] **b.** Pode ser composta com outras funções puras para criar novas funções puras.
* [ ] **c.** Não possui efeitos colaterais.
* [x] **d.** Modifica o estado de uma variável global.
* [ ] **e.** Não depende de variáveis externas mutáveis.

---

## Questão 39

Sobre funções puras e transparência referencial, é correto afirmar que:

* [ ] **a.** Funções puras deixam de ser referencialmente transparentes se acessarem variáveis imutáveis globais.
* [ ] **b.** Toda expressão referencialmente transparente é uma função pura.
* [x] **c.** Toda função pura é referencialmente transparente.
* [ ] **d.** Apenas funções puras podem ser referencialmente transparentes.
* [ ] **e.** Funções puras são referencialmente transparentes pois podem acessar variáveis globais mutáveis.

---

## Questão 40

Qual das alternativas abaixo é uma vantagem do uso de funções puras?

* [ ] **a.** Aumentam a ocorrência de efeitos colaterais.
* [ ] **b.** Tornam o código mais dependente do ambiente externo.
* [ ] **c.** Tornam o código menos previsível.
* [x] **d.** Facilitam a composição e reutilização de código.
* [ ] **e.** Dificultam o teste do código.

---

## Questão 41

Sobre o uso de laços imperativos na programação funcional, **assinale TODAS as alternativas corretas:**

* [x] **a.** A programação funcional desestimula o uso de laços imperativos, preferindo recursão ou funções de ordem superior.
* [x] **b.** Qualquer programa que utiliza laços imperativos pode ser reescrito de forma funcional, substituindo os laços por recursão ou funções de ordem superior.
* [ ] **c.** Laços imperativos independem de mutabilidade e, por isso, são igualmente importantes em todos os paradigmas de programação.
* [ ] **d.** Laços imperativos são invariavelmente mais eficientes, pois a recursão em linguagens funcionais é sempre custosa e não pode ser otimizada.
* [ ] **e.** Laços imperativos são fundamentais para a programação funcional, pois há problemas que não podem ser resolvidos com recursão ou funções de ordem superior.

---

## Questão 42

Sobre recursividade na programação funcional, assinale a alternativa correta:

* [ ] **a.** Recursão sempre consome menos memória que laços imperativos.
* [ ] **b.** Recursão deve ser evitada pois sempre consome muito espaço de pilha de execução.
* [x] **c.** Recursão é utilizada para evitar o uso de variáveis de controle mutáveis em laços imperativos.
* [ ] **d.** Recursão é inviável para processar grandes volumes de dados devido ao alto consumo de memória.
* [ ] **e.** Recursão não pode ser otimizada em linguagens funcionais.

---

## Questão 43

O que é recursão de cauda (tail recursion)?

* [ ] **a.** Uma recursão em que a chamada recursiva consome apenas a cauda de uma lista imutável.
* [ ] **b.** Uma recursão que utiliza variáveis globais.
* [ ] **c.** Uma recursão que ignora a cabeça da lista e processa apenas a cauda.
* [x] **d.** Uma forma de recursão em que a chamada recursiva é a última operação da função.
* [ ] **e.** Uma recursão que com grande volumes de dados gera estouro de pilha.

---

## Questão 44

Em relação à recursão e otimização de chamadas na cauda (tail call optimization), assinale a alternativa correta:

* [ ] **a.** Recursão de cauda sempre consome menos memória que recursão comum.
* [x] **b.** A recursão de cauda, quando otimizada, permite que o tamanho da pilha de execução mantenha-se constante.
* [ ] **c.** Todas as linguagens de programação otimizam automaticamente chamadas recursivas na cauda.
* [ ] **d.** Java e Python possuem otimização de recursão na cauda nativamente.
* [ ] **e.** A otimização de recursão de cauda elimina a necessidade de recursão em linguagens funcionais.

---

## Questão 45

Sobre transparência referencial, marque a alternativa correta:

* [ ] **a.** Uma expressão é referencialmente transparente se não gera efeitos colaterais.
* [x] **b.** Uma expressão é referencialmente transparente se pode ser substituída por seu valor sem alterar o comportamento do programa.
* [ ] **c.** Apenas funções podem ser referencialmente transparentes.
* [ ] **d.** Uma expressão é referencialmente transparente se sempre resulta no mesmo valor, independentemente do estado do programa.
* [ ] **e.** Comandos são sempre referencialmente transparentes se ao serem avaliados geram um valor.
