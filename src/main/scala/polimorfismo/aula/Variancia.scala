package polimorfismo.aula

class Conteiner[T](var value: T)

val c1: Conteiner[String] = Conteiner("texto")
// val c2: Conteiner[AnyRef] = c1  // só seria permitido se fosse covariante
// c2.value = Integer(42)          // compilaria, mas explodiria em runtime

trait Box[+T]:
    // def set(x: T): Unit  // ERRO: covariant type T occurs in contravariant position
    def set[B >: T](x: B): Box[B]
    // Em vez de set receber T diretamente (posição contravariante proibida), ele recebe um novo parâmetro B que é supertipo de T (B >: T). Isso é seguro porque B não é mais o T covariante da classe — é um tipo novo, inferido no momento da chamada, sempre amplo o suficiente para acomodar o valor recebido
