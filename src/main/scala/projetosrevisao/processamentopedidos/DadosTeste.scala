package projetosrevisao.processamentopedidos

object DadosTeste:

    val pedidos: List[Pedido] = List(
        Pedido(
            id = 1,
            cliente = "João",
            itens = List(
                Item("Notebook", 3500.00, 1),
                Item("Mouse", 89.90, 2),
                Item("Teclado", 250.00, 1)
            )
        ),

        Pedido(
            id = 2,
            cliente = "Maria",
            itens = List(
                Item("Caderno", 15.50, 4),
                Item("Caneta", 3.00, 10)
            )
        ),

        Pedido(
            id = 3,
            cliente = "João",
            itens = List(
                Item("Fone de ouvido", -50.00, 1),
                Item("Carregador", 45.00, 2)
            )
        ),

        Pedido(
            id = 4,
            cliente = "Carlos",
            itens = List(Item("Monitor", 899.90, 0))
        ),

        Pedido(
            id = 5,
            cliente = "Ana",
            itens = List.empty
        ),

        Pedido(
            id = 6,
            cliente = "Maria",
            itens = List(Item("Livro", 45.00, 1))
        ),

        Pedido(
            id = 7,
            cliente = "João",
            itens = List(
                Item("Cadeira Gamer", 1200.00, 1),
                Item("Mesa", 450.00, 1)
            )
        ),

        Pedido(
            id = 8,
            cliente = "Pedro",
            itens = List(Item("Webcam", 150.00, -1))
        )
    )

    val precosParaParsear: List[String] = List("3.5", "89.90", "abc", "", "100")