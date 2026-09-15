package compestados.aula

// Imperativo: muta em-place
// object Counter:
//   private var counter = 0
//   def increment: Unit = counter += 1

// Funcional: cada increment gera um NOVO objeto
case class Counter private (value: Int):
  def increment = Counter(value + 1)

object Counter:
  def apply(): Counter = new Counter(0)

val c1 = Counter()
val c2 = c1.increment  // c1 continua existindo, intacto
val c3 = c2.increment
// c1, c2 e c3 coexistem — isso é persistência. O "preço" é que você precisa de uma variável nova a cada passo (state threading explícito)
