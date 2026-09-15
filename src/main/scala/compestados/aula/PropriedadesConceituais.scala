package compestados.aula

// Exemplo prático — gerador de números pseudoaleatórios (RNG) como estudo de caso clássico
// RNGs são o exemplo canônico porque, no imperativo, geram números "aleatórios" via mutação de uma seed interna (efeito colateral escondido). Em FP, a seed é só estado explícito:

case class Seed(value: Long):
  def next: Seed = Seed(value * 6364136223846793005L + 1442695040888963407L)

def nextInt: State[Seed, Int] =
  State(seed => (seed.next, (seed.next.value >>> 16).toInt))

val program = for
  a <- nextInt
  b <- nextInt
  c <- nextInt
yield (a, b, c)

val (finalSeed, (x, y, z)) = program.run(Seed(42L))

// Rodar program.run(Seed(42L)) sempre produz exatamente os mesmos (x, y, z) — reprodutibilidade total. E nada impede rodar program.run(Seed(99L)) em paralelo, sem nenhuma interferência entre as duas execuções (bifurcação)