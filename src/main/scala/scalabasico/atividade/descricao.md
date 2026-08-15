# Descrição da atividade

A atividade tem como objetivo praticar recursos básicos de programação em **Scala**, especialmente o uso de variáveis, tipos de dados, funções e listas. A proposta consiste na implementação de cinco funções, todas seguindo os princípios de programação funcional.

## 1. Equação do segundo grau

A função `quadraticFunctionRoots` recebe três coeficientes `a`, `b` e `c` do tipo `Double` e deve calcular as raízes reais de uma equação do segundo grau.

```scala
def quadraticFunctionRoots(a: Double, b: Double, c: Double): List[Double]
```

A função deve:

* retornar uma `List[Double]` contendo as raízes reais da equação;
* retornar uma lista vazia quando não for possível determinar raízes reais;
* considerar como inválida uma equação cujo coeficiente `a` seja igual a zero;
* retornar uma lista vazia quando o discriminante resultar em raízes complexas;
* considerar casos em que exista apenas uma raiz real.

Por exemplo:

```scala
quadraticFunctionRoots(1.2, -34.5, 5.8)
// List(0.169, 28.581)

quadraticFunctionRoots(1, 0, 0)
// List(0.0)

quadraticFunctionRoots(1, 2, 3)
// List()
```

Para o cálculo da raiz quadrada, pode ser utilizada a função `scala.math.sqrt`.

## 2. Custo de entrega

A função `deliveryBill` deve calcular o valor de uma compra realizada em um aplicativo de delivery. A compra possui apenas um tipo de produto e é identificada pelo código do produto e pela quantidade solicitada.

```scala
def deliveryBill(code: Int, quantity: Int): List[Double]
```

A função deve considerar os seguintes produtos:

| Código | Produto         |    Preço |  Peso |
| -----: | --------------- | -------: | ----: |
|      1 | Cachorro quente |  R$ 8,00 | 150 g |
|      2 | X-salada        | R$ 13,50 | 240 g |
|      3 | X-Bacon         | R$ 15,00 | 280 g |
|      4 | Fritas          | R$ 17,50 | 300 g |
|      5 | Brownie         |  R$ 5,50 |  50 g |
|      6 | Refrigerante    |  R$ 5,00 | 330 g |

Além do preço dos produtos, deve ser considerada uma taxa de entrega:

* **R$ 4,00** para pedidos com peso total de até 1 kg;
* **R$ 8,00** para pedidos com peso total superior a 1 kg.

O resultado deve ser uma `List[Double]` contendo, respectivamente:

1. o subtotal da compra;
2. a taxa de entrega;
3. o total a pagar.

Caso o código do produto seja inválido ou a quantidade seja zero ou negativa, a função deve retornar uma lista vazia.

## 3. Intercalação de listas

A função `interleaveLists` recebe duas listas de inteiros e deve intercalar seus elementos.

```scala
def interleaveLists(l1: List[Int], l2: List[Int]): List[Int]
```

As duas listas devem possuir **exatamente três elementos**. Considerando:

```text
l1 = List(a, b, c)
l2 = List(x, y, z)
```

o resultado esperado é:

```text
List(a, x, b, y, c, z)
```

Por exemplo:

```scala
interleaveLists(List(1, 2, 3), List(10, 20, 30))
// List(1, 10, 2, 20, 3, 30)

interleaveLists(List(-1, 0, 1), List(5, 6, 7))
// List(-1, 5, 0, 6, 1, 7)
```

Se qualquer uma das listas não possuir exatamente três elementos, a função deve retornar uma lista vazia.

## 4. Diferença de tempo

A função `timeDifference` deve calcular a diferença absoluta, em segundos, entre dois horários do mesmo dia.

```scala
def timeDifference(t1: List[Int], t2: List[Int]): Int
```

Cada horário deve ser representado por uma lista contendo exatamente três inteiros:

```text
List(horas, minutos, segundos)
```

Um horário válido deve possuir:

* horas no intervalo permitido para um dia;
* minutos entre 0 e 59;
* segundos entre 0 e 59.

A função deve retornar a diferença absoluta entre os dois horários, convertendo-os para segundos.

Caso algum dos horários seja inválido ou alguma das listas não possua exatamente três elementos, o resultado deve ser `-1`.

Exemplos:

```scala
timeDifference(List(10, 15, 30), List(10, 15, 30))
// 0

timeDifference(List(10, 0, 0), List(11, 30, 0))
// 5400

timeDifference(List(23, 59, 59), List(23, 59, 0))
// 59

timeDifference(List(24, 0, 0), List(10, 0, 0))
// -1
```

## 5. Validação de data

A função `validateDate` deve verificar se uma data é válida.

```scala
def validateDate(day: Int, month: Int, year: Int): Boolean
```

Para que uma data seja considerada válida:

* o ano deve ser estritamente maior que zero;
* o mês deve estar entre 1 e 12;
* o dia deve ser maior ou igual a 1;
* o dia não pode ultrapassar o número máximo de dias do mês.

A quantidade de dias de cada mês segue estas regras:

* **31 dias:** janeiro, março, maio, julho, agosto, outubro e dezembro;
* **30 dias:** abril, junho, setembro e novembro;
* **28 dias:** fevereiro em anos comuns;
* **29 dias:** fevereiro em anos bissextos.

Um ano é considerado bissexto quando:

* é divisível por 400; ou
* é divisível por 4 e não é divisível por 100.

A função deve retornar `true` para datas válidas e `false` para datas inválidas.

Exemplos:

```scala
validateDate(15, 8, 2024)
// true

validateDate(29, 2, 2024)
// true

validateDate(29, 2, 2023)
// false

validateDate(31, 4, 2024)
// false
```

## Restrições de implementação

Todas as funções devem ser **puras, determinísticas e sem efeitos colaterais**. Portanto, a implementação não deve utilizar:

* variáveis mutáveis, como `var` ou estruturas `mutable`;
* estruturas de controle imperativas, como `for`, `while` ou `do-while`;
* disparo ou tratamento de exceções, como `throw` ou `try-catch`;
* funções de entrada e saída, como `print`, `readLine` ou `System.out.println`;
* funções não puras, como `System.exit`;
* bibliotecas externas que não sejam puras;
* estruturas de dados mutáveis do Scala, como `Array`, `ListBuffer` ou `scala.collection.mutable.Map`.
