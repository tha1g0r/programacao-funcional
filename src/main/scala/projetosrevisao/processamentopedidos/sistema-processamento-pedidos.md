# Mini-Projeto: Sistema de Processamento de Pedidos (E-commerce)

Um cenário único que força você a usar praticamente tudo dos capítulos 1–5, com pureza funcional obrigatória (sem `var`, sem loops imperativos, sem mutação — exceto onde eu explicitar o contrário).

---

## Contexto

Você vai modelar o processamento de uma lista de pedidos de uma loja. Cada pedido tem itens, e cada item tem preço e quantidade. Existem regras de validação, cálculo, e tratamento de erros.

---

## Tipos base (dados fornecidos — não mude a assinatura)

```scala
case class Item(nome: String, preco: Double, quantidade: Int)
case class Pedido(id: Int, cliente: String, itens: List[Item])
```

---

## Parte 1 — Funções puras e recursão (Ch. 1, 2, 4)

**1.1** — `calcularTotalPedido(pedido: Pedido): Double`
Soma `preco * quantidade` de todos os itens. Implemente **de duas formas**:
- `calcularTotalPedidoRecursivo` — recursão explícita (sem `foldLeft`), usando `@tailrec`.
- `calcularTotalPedidoHOF` — usando combinadores de coleção (`map`/`sum` ou `foldLeft`).

**1.2** — `contarItens(pedido: Pedido): Int`
Conta a quantidade total de itens (soma de `quantidade`), recursivo com acumulador — **mas sem expor o acumulador na assinatura pública** (você já identificou esse problema de design antes, então aplique aqui: crie uma função interna/privada para o acumulador).

---

## Parte 2 — Funções de ordem superior e composição (Ch. 3)

**2.1** — `aplicarDesconto(taxa: Double): Item => Item`
Retorna uma função (currying/closure) que aplica um desconto percentual ao preço de um item.

**2.2** — `filtrarPedidosValidos(pedidos: List[Pedido], predicado: Pedido => Boolean): List[Pedido]`
Genérica, recebe um predicado como parâmetro.

**2.3** — Componha funções: crie `pedidoCaro: Pedido => Boolean` (total > 500) e `pedidoDoCliente(nome: String): Pedido => Boolean`, depois combine ambas com uma função `combinarPredicados` que una dois predicados com "E lógico" (isso é essencialmente function composition).

---

## Parte 3 — Tratamento de erros (Ch. 5) — o núcleo do exercício

Regras de negócio:
- Um `Item` é inválido se `preco < 0` ou `quantidade <= 0`.
- Um `Pedido` é inválido se a lista de itens estiver vazia, ou se contiver algum item inválido.
- Ao processar uma string de entrada tipo `"3.5"` para preço, pode ocorrer erro de parsing.

**3.1** — `validarItem(item: Item): Either[String, Item]`
Retorna `Left(mensagem de erro)` ou `Right(item)`.

**3.2** — `validarPedido(pedido: Pedido): Either[String, Pedido]`
Deve agregar a validação de todos os itens — se **qualquer** item for inválido, retorna o primeiro erro encontrado. Use `for`-comprehension (cuidado com o double-wrapping que você já pegou antes!).

**3.3** — `parsePreco(s: String): Try[Double]`
Converte string pra `Double` (uso de `Try` sobre `.toDouble`).

**3.4** — `buscarItem(pedido: Pedido, nome: String): Option[Item]`
Busca um item pelo nome no pedido, retorna `Option`.

**3.5** — Função de integração: `processarPedido(pedido: Pedido): Either[String, Double]`
Valida o pedido (3.2) e, se válido, retorna o total calculado (1.1) dentro de um `Right`.

---

## Parte 4 — Memoização (Ch. 4)

**4.1** — Suponha que calcular o "score de fidelidade" de um cliente é uma operação cara (simule com uma função recursiva tipo Fibonacci do nome do cliente, por exemplo, baseada no tamanho da string). Implemente `scoreFidelidade` com memoização usando `mutable.Map` (única exceção permitida a mutabilidade, como no curso).

---

## Entrega esperada

Um único arquivo `.scala` com todas as funções acima, mais um pequeno `@main` que:
1. Cria uma lista de 3-4 pedidos (alguns válidos, alguns inválidos).
2. Processa todos com `processarPedido`, imprimindo sucesso/erro de cada um.

---

**Regras de lint que você deve respeitar:** sem `var`, sem `while`/`for` imperativo (só `for`-comprehension monádico ou `foreach` em último caso), sem `return`, recursão de cauda anotada com `@tailrec` onde fizer sentido.
