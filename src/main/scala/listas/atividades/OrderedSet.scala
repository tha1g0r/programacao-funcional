package listas.atividades

/**
  * Conjuntos Imutáveis sobre Listas Ordenadas
  * 
  * Esta classe representa um conjunto de operações sobre conjuntos representados
  * diretamente como listas ordenadas e sem duplicados (List[A]).
  * 
  * A classe é parametrizada com uma função de comparação.
  * 
  * Exemplo de uso:
  * {{{
  * val setOp = new OrderedSet[Int]((x, y) => x.compare(y))
  * val s1 = List(1, 3, 5)
  * val s2 = List(2, 3, 6)
  * 
  * setOp.insert(s1, 4)      // Retorna: List(1, 3, 4, 5)
  * setOp.union(s1, s2)       // Retorna: List(1, 2, 3, 5, 6)
  * setOp.intersect(s1, s2)   // Retorna: List(3)
  * setOp.difference(s1, s2)  // Retorna: List(1, 5)
  * }}}
*/
class OrderedSet[A](val comp: (A, A) => Int) {

    /**
      * Insere um elemento no conjunto representado por uma lista ordenada.
      * Mantém a ordenação crescente e não duplica o elemento se já existir.
      * 
      * Complexidade: O(N)
      * 
      * @param set Conjunto representado por uma lista ordenada
      * @param elem Elemento a ser inserido
      * @return Nova lista ordenada com o elemento inserido
    */
    def insert(set: List[A], elem: A): List[A] = set match
        case Nil => List(elem)
        case head :: tail =>
            comp(elem, head) match
                case result if result < 0 => elem :: set
                case 0 => set
                case _ => head :: insert(tail, elem)

    /**
      * Realiza a união de dois conjuntos ordenados.
      * O resultado deve ser ordenado e sem duplicados.
      * Deve ser implementada em tempo O(N + M) de forma puramente recursiva.
      * 
      * Complexidade: O(N + M)
      * 
      * @param set1 Primeiro conjunto
      * @param set2 Segundo conjunto
      * @return União dos conjuntos
    */
    def union(set1: List[A], set2: List[A]): List[A] = {
        ???
    }

    /**
      * Realiza a interseção de dois conjuntos ordenados.
      * Retorna apenas os elementos presentes em ambos os conjuntos.
      * Deve ser implementada em tempo O(N + M) de forma puramente recursiva.
      * 
      * Complexidade: O(N + M)
      * 
      * @param set1 Primeiro conjunto
      * @param set2 Segundo conjunto
      * @return Interseção dos conjuntos
    */
    def intersect(set1: List[A], set2: List[A]): List[A] = {
        ???
    }

    /**
      * Realiza a diferença entre dois conjuntos ordenados (set1 \ set2).
      * Retorna apenas os elementos de set1 que não estão em set2.
      * Deve ser implementada em tempo O(N + M) de forma puramente recursiva.
      * 
      * Complexidade: O(N + M)
      * 
      * @param set1 Primeiro conjunto
      * @param set2 Segundo conjunto
      * @return Diferença (set1 \ set2)
    */
    def difference(set1: List[A], set2: List[A]): List[A] = {
        ???
    }
}

@main def mainOrderesSet(): Unit =
    val setOp = new OrderedSet[Int]((x, y) => x.compare(y))
    val s1 = List(1, 3, 5)
    val s2 = List(2, 3, 6)

    println(setOp.insert(s1, 4))
