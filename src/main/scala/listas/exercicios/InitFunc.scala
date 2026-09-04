package listas.exercicios

def init[A](xs: List[A]): List[A] = xs match
    case Nil => Nil
    case _ :: Nil => Nil
    case head :: tail => head :: init(tail)

// A complexidade de tempo é O(n), onde n é o número de elementos na lista, pois o algoritmo precisa percorrer recursivamente a lista até atingir o penúltimo elemento
// A complexidade de espaço na pilha de chamadas é O(n), devido à profundidade da recursão simples
// Em termos de compartilhamento estrutural, a operação não compartilha memória com a lista original. Como o último elemento é descartado, o nó anterior a ele precisa ter seu ponteiro de cauda (tail) apontando para Nil. Dada a imutabilidade das células cons (::), não é possível modificar o tail de um nó existente. Portanto, esse penúltimo nó precisa ser recriado. Isso, por sua vez, obriga a recriação do nó anterior a ele, e assim consecutivamente até a cabeça da lista. Logo, toda a lista restante (de tamanho n − 1) é duplicada em memória, resultando em complexidade de espaço O(n) e consumo de novos nós

@main def mainInitFunc(): Unit =
    val lista = (1 to 5).toList

    println(init(lista))
