/**
  * Representação de um item comercial no e-commerce.
  *
  * @param id Identificador único do item
  * @param basePrice Preço base (sem taxas ou descontos)
  * @param category Categoria do produto (ex: "Electronics", "Books")
  * @param weight Peso do item em quilogramas (kg)
  */
case class Item(id: String, basePrice: Double, category: String, weight: Double)

/**
  * Modificador de preço representado como uma função pura que transforma um preço (Double) em outro.
  */
type PriceModifier = Double => Double

/**
  * Cria uma regra de desconto percentual.
  *
  * @param percentage Valor decimal do desconto (ex: 0.10 para 10%)
  * @return Um PriceModifier que reduz o preço na porcentagem dada
  */
def discount(percentage: Double): PriceModifier = {
  // TODO: Implementar usando currying
  ???
}

/**
  * Cria uma regra de acréscimo de imposto (taxa).
  *
  * @param rate Taxa de imposto a ser aplicada (ex: 0.12 para 12%)
  * @return Um PriceModifier que aumenta o preço na taxa dada
  */
def tax(rate: Double): PriceModifier = {
  // TODO: Implementar usando currying
  ???
}

/**
  * Cria uma regra de frete baseada no peso do item (usando Currying).
  *
  * @param costPerKg Custo cobrado por quilograma
  * @param weight Peso do item em kg
  * @return Um PriceModifier que soma o custo do frete ao preço
  */
def shipping(costPerKg: Double)(weight: Double): PriceModifier = {
  // TODO: Implementar usando currying e aplicação parcial
  ???
}

/**
  * Construtor de modificadores condicionais de preço.
  *
  * Se a condição for verdadeira para o item, o modificador é aplicado ao preço.
  * Caso contrário, o preço é mantido inalterado (usando a função identidade).
  *
  * @param condition Predicado a ser avaliado sobre o Item
  * @param modifier O modificador a ser aplicado se a condição for satisfeita
  * @return Uma função que recebe um Item e produz um PriceModifier correspondente
  */
def applyIf(condition: Item => Boolean, modifier: PriceModifier): Item => PriceModifier = {
  // TODO: Implementar a lógica condicional e retornar o PriceModifier correspondente
  ???
}

/**
  * Constrói o pipeline completo de precificação composto de múltiplos modificadores para um dado Item.
  *
  * Regras a serem aplicadas na ordem abaixo:
  * - Se for "Electronics": desconto de 10%, imposto de 12%, frete de R$ 2.0 por kg.
  * - Se for "Books": desconto de 15%, imposto de 0% (isento), frete fixo de R$ 5.0.
  * - Caso contrário: nenhuma regra é aplicada (preço base mantido).
  *
  * Dica: Use a função `applyIf` definida anteriormente e faça composição linear usando `andThen`.
  *
  * @param item O Item a ser precificado
  * @return Um PriceModifier contendo todas as regras aplicáveis encadeadas por andThen
  */
def pricingPipeline(item: Item): PriceModifier = {
  // TODO: Implementar o pipeline composto usando composição com `andThen`
  ???
}

/**
  * Filtra itens inválidos do carrinho (preço base menor ou igual a zero), aplica o pipeline
  * de precificação em cada item individualmente e calcula a soma total de todos os itens precificados.
  *
  * @param cart Lista contendo os itens do carrinho
  * @return O preço final totalizado do carrinho precificado
  */
def calculateCartTotal(cart: List[Item]): Double = {
  // TODO: Filtrar itens com basePrice <= 0, precificar cada um e acumular o valor total
  ???
}

@main def runPricing(): Unit = {
  // val cart = List(
  //   Item("1", 100.0, "Electronics", 2.0),
  //   Item("2", 20.0, "Books", 0.5),
  //   Item("3", -5.0, "Invalid", 1.0)
  // )
  // Descomente a linha abaixo após implementar as funções para testar manualmente:
  // println(s"Total calculado do carrinho: R$$ ${calculateCartTotal(cart)}")
}