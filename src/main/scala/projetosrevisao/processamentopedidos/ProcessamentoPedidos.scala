package projetosrevisao.processamentopedidos

import DadosTeste.*
import scala.annotation.tailrec

// Tipos base
case class Item(nome: String, preco: Double, quantidade: Int)
case class Pedido(id: Int, cliente: String, itens: List[Item])

// Funções puras e recursivas

    // Cálculo de valor total
def calcularTotalPedidoRecursivo(pedido: Pedido): Double =
    @tailrec
    def loopHelper(itens: List[Item], acc: Double): Double =
        if itens.isEmpty then acc
        else loopHelper(itens.tail, acc + itens.head.preco * itens.head.quantidade)

    loopHelper(pedido.itens, acc = 0)

def calcularTotalPedidoHOF(pedido: Pedido): Double =
    pedido.itens.map(item => item.preco * item.quantidade).sum

    // Contar quantidade de itens
def contarItens(pedido: Pedido): Int =
    @tailrec
    def loopHelper(itens: List[Item], acc: Int): Int =
        if itens.isEmpty then acc
        else loopHelper(itens.tail, acc + itens.head.quantidade)

    loopHelper(pedido.itens, acc = 0)

// Funções de ordem superior e composição

    // criar aplicador de desconto
def aplicarDesconto(taxa: Double): Item => Item =
    item => Item(item.nome,
                 item.preco * (1 - taxa),
                 item.quantidade)

    // Filtrar pedidos
def filtrarPedidosValidos(pedidos: List[Pedido], predicado: Pedido => Boolean): List[Pedido] =
    pedidos.filter(predicado)

    // Combinação predicados
val pedidoCaro: Pedido => Boolean =
    pedido => calcularTotalPedidoHOF(pedido) > 500

val pedidoDoCliente: String => Pedido => Boolean =
    nome => pedido => pedido.cliente == nome

val combinarPredicados: (Pedido => Boolean, Pedido => Boolean) => Pedido => Boolean =
    (p1, p2) =>
        pedido => p1(pedido) && p2(pedido)

@main def mainProcessamentoPedidos(): Unit =

    // testes
    println("===== Testes =====")

    println("\nCálculo valor total:")
    println(s"3929.8 -> ${calcularTotalPedidoRecursivo(pedidos(0))}") // 35 + 45 + 88 + 80 = 248.0
    println(s"3929.8 -> ${calcularTotalPedidoHOF(pedidos(0))}")

    println("\nCálculo quantidade de itens:")
    println(s"4 -> ${contarItens(pedidos(0))}") // 1 + 3 + 4 + 2 = 10

    println("\nAplicador de desconto:")
    val desconto10 = aplicarDesconto(0.1)
    println(s"225.0 -> ${desconto10(pedidos(0).itens(2)).preco}") // 40 * 0.9 = 36

    println("\nFiltrar pedidos:")
    val pedidoNaoVazio: Pedido => Boolean =
        pedido => !pedido.itens.isEmpty
    println(s"List(<id = 2, 6>) -> ${filtrarPedidosValidos(pedidos, pedidoDoCliente("Maria"))}")
    println(s"List(<id != 5>) -> ${filtrarPedidosValidos(pedidos, pedidoNaoVazio)}")

    println("\nCombinação Predicados:")
    val caroEDoJoao = combinarPredicados(pedidoCaro, pedidoDoCliente("João"))
    println(s"List(<id = 1, 7>) -> ${filtrarPedidosValidos(pedidos, caroEDoJoao)}")
    
