## 🎯 Mini-projeto: Sistema de Reservas de Sala de Reunião

### Tipos-base (fornecidos)

```scala
case class Sala(nome: String, capacidade: Int)

case class Horario(inicio: Int, fim: Int) // horas em formato 24h (0-23)

case class SolicitacaoReserva(
  sala: Sala,
  horario: Horario,
  numParticipantes: Int,
  solicitante: String
)
```

---

### Parte 1 — Tratamento de erros (Cap. 5)

ADT de erro:

```scala
enum ErroReserva:
  case HorarioInvalido
  case SalaLotada
  case SolicitanteInvalido
```

Implemente:

```scala
def validarSolicitacao(s: SolicitacaoReserva): Either[ErroReserva, SolicitacaoReserva]
```

Regras:
- `HorarioInvalido`: `inicio >= fim`, ou `inicio < 0`, ou `fim > 23`
- `SalaLotada`: `numParticipantes > sala.capacidade`
- `SolicitanteInvalido`: `solicitante` vazio ou só espaços em branco

Sem `if/else` aninhado imperativo, sem `throw`. Pode usar `for-comprehension` com `Either` se fizer sentido.

---

### Parte 2 — Abstração de dados (Cap. 6)

```scala
class Agenda private (val sala: Sala, val reservas: List[Horario]):
  def adicionarReserva(h: Horario): Agenda = ???
  def temConflito(h: Horario): Boolean = ???

object Agenda:
  def apply(sala: Sala): Agenda = ???
```

- `temConflito`: dois horários conflitam se há **sobreposição** de intervalos (não apenas igualdade exata) — pense no caso `[9,11]` vs `[10,12]`.
- `adicionarReserva` retorna uma **nova** `Agenda` (imutabilidade — nada de `var`, nada de mutação da lista).
- Construtor privado + `apply` no companion object, como vimos no Cap. 6.

---

### Parte 3 — Tipos algébricos e pattern matching (Cap. 7)

```scala
enum ResultadoReserva:
  case Confirmada(agenda: Agenda)
  case Conflito(horarioExistente: Horario)
  case Invalida(erro: ErroReserva)
```

Implemente, **nessa ordem fixa**:

```scala
def processarReserva(agenda: Agenda, s: SolicitacaoReserva): ResultadoReserva
```

1. Primeiro valida a solicitação (Parte 1). Se inválida → `Invalida(erro)`.
2. Se válida, checa conflito na agenda (Parte 2). Se houver conflito → `Conflito(horarioExistente)` (retorne o horário específico que conflitou).
3. Se não houver conflito → `Confirmada(novaAgenda)` com a reserva já adicionada.

Use casamento de padrões exaustivo — sem `case _ =>` disfarçando casos.

---

### Regras gerais
- Sem `var`, sem loop imperativo, sem `return`.
- `@tailrec` onde precisar de recursão explícita (embora aqui provavelmente você vai resolver tudo com `map`/`filter`/`exists`/`for`, sem precisar de recursão manual).
