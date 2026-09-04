package listas.exercicios

def take[A](xs: List[A], n: Int): List[A] = (xs, n) match
    case (Nil, _) => Nil
    case (_, num) if num <= 0 => Nil
    case (head :: tail, num) => head :: take(tail, num - 1)

// Na função take, o resultado é uma nova lista contendo os primeiros n elementos. O último elemento do resultado deve apontar para Nil. Pela imutabilidade das células cons (::), não podemos alterar a referência de cauda de um nó existente para apontar para Nil. Portanto, todos os n elementos mantidos precisam ter seus nós recriados em memória. A complexidade de espaço é O(n)(onde n é o número de elementos mantidos) e não ocorre compartilhamento estrutural com os nós correspondentes da lista original, embora a cauda seja descartada

def drop[A](xs: List[A], n: Int): List[A] = (xs, n) match
    case (Nil, _) => Nil
    case (l, num) if num <= 0 => l
    case(_ :: tail, num) => drop(tail, num - 1)

// Na função drop, a recursão apenas avança os ponteiros da lista, descartando referências aos primeiros n nós. Quando a recursão para (caso base n ≤ 0), ela retorna a referência ao nó atual da lista original. Portanto, a lista resultante aponta diretamente para o mesmo endereço de memória da sublista restante na lista original. Não há alocação de novos nós, resultando em complexidade de espaço O(1) (para além da pilha de execução) e ocorre compartilhamento estrutural completo da lista resultante com a lista original

@main def mainTakeDropFuncs(): Unit =
    val lista = (1 to 5).toList

    println(take(lista, 3))
    println(drop(lista, 3))
