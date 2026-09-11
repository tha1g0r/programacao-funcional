package polimorfismo.aula

sealed trait PaymentMethod
case class CreditCard(number: String) extends PaymentMethod
case class Pix(key: String) extends PaymentMethod
case class Boleto(code: String) extends PaymentMethod

def process(p: PaymentMethod): String = p match
    case CreditCard(n) => s"Processando cartão $n"
    case Pix(k) => s"Processando PIX $k"
    case Boleto(c) => s"Processando boleto $c"
