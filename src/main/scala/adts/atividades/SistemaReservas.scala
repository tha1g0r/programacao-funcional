package adts.atividades

import adts.atividades.ResultadoReserva.Conflito

// Tipos-base
case class Sala(nome: String, capacidade: Int)

case class Horario(inicio: Int, fim: Int) // horas em formato 24h (0-23)

case class SolicitacaoReserva(
  sala: Sala,
  horario: Horario,
  numParticipantes: Int,
  solicitante: String
)

// Tratamento de erros

enum ErroReserva:
    case HorarioInvalido
    case SalaLotada
    case SolicitanteInvalido

def validarSolicitacao(s: SolicitacaoReserva): Either[ErroReserva, SolicitacaoReserva] =
    val validarHorario: SolicitacaoReserva => Either[ErroReserva, SolicitacaoReserva] =
        s => if s.horario.inicio >= s.horario.fim || s.horario.inicio < 0 || s.horario.fim > 23 then Left(ErroReserva.HorarioInvalido) else Right(s)

    val validarCapacidade: SolicitacaoReserva => Either[ErroReserva, SolicitacaoReserva] =
        s => if s.numParticipantes > s.sala.capacidade then Left(ErroReserva.SalaLotada) else Right(s)

    val validarSolicitante: SolicitacaoReserva => Either[ErroReserva, SolicitacaoReserva] =
        s => if s.solicitante.isBlank then Left(ErroReserva.SolicitanteInvalido) else Right(s)

    for
        s1 <- validarHorario(s)
        s2 <- validarCapacidade(s1)
        s3 <- validarSolicitante(s2)
    yield s3

// Abstração de dados

class Agenda private (val sala: Sala, val reserva: List[Horario]):
    def adicionarReserva(h: Horario): Either[Horario, Agenda] =
        temConflito(h) match
            case None => Right(new Agenda(sala, reserva :+ h))
            case Some(horarioConflitante) => Left(horarioConflitante)
    def temConflito(h: Horario): Option[Horario] =
        def verificar(horarios: List[Horario]): Option[Horario] =
            horarios match
                case Nil => None
                case horarioAtual :: horariosRestantes =>
                    val conflito = h.inicio < horarioAtual.fim &&
                                   horarioAtual.inicio < h.fim
                    if conflito then Some(horarioAtual)
                    else verificar(horariosRestantes)
        verificar(reserva)

object Agenda:
    def apply(sala: Sala): Agenda = new Agenda(sala, Nil)

@main def mainSistemaReservas(): Unit =
    ???
