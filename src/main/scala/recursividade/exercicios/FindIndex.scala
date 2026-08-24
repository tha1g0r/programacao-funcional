package recursividade.exercicios

import scala.annotation.tailrec

def findIndex(list: List[Int], target: Int): Int = {
    var i = 0
    var found = false
    var index = -1
    while (i < list.length && !found) {
        if (list(i) == target) {
            found = true
            index = i
        }
        i += 1
    }
    index
}

def RecursiveFindIndex(list: List[Int], target: Int): Int =
    @tailrec
    def loopHelper(remaining: List[Int], currentIdx: Int): Int =
        if remaining.isEmpty then -1
        else if remaining.head == target then currentIdx
        else loopHelper(remaining.tail, currentIdx + 1)
    
    loopHelper(list, 0)

@main def mainFindReverse(): Unit =
    println(findIndex(List(1, 2, 10, 14, 18, 26), 14))
    println(RecursiveFindIndex(List(1, 2, 10, 14, 18, 26), 18))
