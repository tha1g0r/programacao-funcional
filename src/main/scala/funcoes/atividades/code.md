# [CODE] Ativ. 3.2 - Funções | Sistema de Precificação Funcional

## 🎯 Objetivos

- Compreender e aplicar os conceitos de **currying** e **aplicação parcial**
- Utilizar a **composição de funções** (`andThen`) para estruturar pipelines de processamento
- Usar **fechamentos** (*closures*) e **funções de ordem superior**
- Manipular e transformar coleções de dados usando **combinadores**

## 📖 Contexto

Uma empresa varejista precisa de um sistema de precificação flexível, onde cada produto recebe um conjunto de regras (descontos, impostos, frete) que variam conforme categoria, promoções e outros fatores. O sistema também deve calcular o total de um carrinho de compras, filtrando itens inválidos e aplicando as regras de precificação de forma acumulada.

## 🧩 O que deve ser implementado

### 1. Regras individuais (com currying)

| Função | Assinatura | Fórmula |
|---|---|---|
| `discount` | `discount(percentage: Double): PriceModifier` | `preco × (1.0 − percentage)` |
| `tax` | `tax(rate: Double): PriceModifier` | `preco × (1.0 + rate)` |
| `shipping` | `shipping(costPerKg: Double)(weight: Double): PriceModifier` | `preco + (costPerKg × weight)` — **usa currying** |

> `type PriceModifier = Double => Double`

### 2. `applyIf` — regras condicionais

```scala
def applyIf(condition: Item => Boolean, modifier: PriceModifier): Item => PriceModifier
```

- Se `condition(item)` for **verdadeiro** → retorna `modifier`
- Se for **falso** → retorna a função identidade (`price => price`)

### 3. `pricingPipeline` — composição com `andThen`

```scala
def pricingPipeline(item: Item): PriceModifier
```

Regras por categoria (aplicadas nessa ordem, via `andThen`):

| Categoria | Desconto | Imposto | Frete |
|---|---|---|---|
| `"Electronics"` | 10% | 12% | R$ 2,00/kg |
| `"Books"` | 15% | 0% (isento) | R$ 5,00 fixo |
| Outras | — | — | — (preço = preço base) |

**Exemplo (Electronics, preço R$100, 2kg):**
`100.0 →(−10%) 90.0 →(+12%) 100.8 →(+frete 2×2) 104.8`

### 4. `calculateCartTotal` — processamento em lote

```scala
def calculateCartTotal(cart: List[Item]): Double
```

1. **Filtrar** itens com `basePrice <= 0`
2. **Precificar** cada item com seu `pricingPipeline`
3. **Somar** os preços finais

**Exemplo:**
```scala
val cart = List(
  Item("1", 100.0, "Electronics", 2.0),
  Item("2", 20.0, "Books", 0.5),
  Item("3", -5.0, "Invalid", 1.0) // descartado
)
calculateCartTotal(cart) // 126.80
```

## 🏗️ Estruturas já fornecidas

- `case class Item(id: String, basePrice: Double, category: String, weight: Double)`
- `type PriceModifier = Double => Double`
- `@main runPricing` — testes locais básicos

## ⛔ Restrições (código deve ser 100% puro)

Proibido usar:
- `var` / `mutable`
- `for`, `while`, `do-while`
- `throw`, `try-catch`
- `print`, `readLine`, `System.out.println`, `System.exit`
- `Array`, `ListBuffer`, `scala.collection.mutable.Map`
- Bibliotecas externas não-puras
