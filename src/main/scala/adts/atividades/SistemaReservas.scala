package adts.atividades

// Tipos-base
case class Sala(nome: String, capacidade: Int)

case class Horario(inicio: Int, fim: Int) // horas em formato 24h (0-23)

case class SolicitacaoReserva(
  sala: Sala,
  horario: Horario,
  numParticipantes: Int,
  solicitante: String
)

@main def mainSistemaReservas(): Unit =
    ???
