package recursividade.atividades

import scala.collection.mutable
import scala.annotation.tailrec

/**
 * Computes the factorial sequence from 0! to n! using a naive recursive approach.
 * 
 * This implementation recalculates factorials from scratch for each position,
 * leading to exponential time complexity due to repeated calculations.
 * 
 * @param n the upper bound of the sequence (inclusive)
 * @return a list containing [0!, 1!, 2!, ..., n!]
 * 
 * Example: factorialSequenceNaive(4) should return [1, 1, 2, 6, 24]
 */
def factorialSequenceNaive(n: Int): List[BigInt] = {
    def factorial(i: Int): BigInt = {
        if (i <= 1) 1
        else i * factorial(i - 1)
    }

    (0 to n).map(factorial).toList
}

/**
 * Computes the factorial sequence from 0! to n! using memoization to cache previously calculated factorials.
 * 
 * This implementation stores computed factorial values in a mutable map to avoid
 * recalculating the same values, significantly improving performance for larger inputs.
 * 
 * @param n the upper bound of the sequence (inclusive)
 * @param memo a mutable map to cache factorial values (key: number, value: factorial)
 * @return a list containing [0!, 1!, 2!, ..., n!]
 * 
 * Example: factorialSequenceMemoized(4, mutable.Map()) should return [1, 1, 2, 6, 24]
 */
def factorialSequenceMemoized(n: Int, memo: mutable.Map[Int, BigInt]): List[BigInt] =
    def factorialMemoized(i: Int): BigInt =
        if i <= 1 then 1
        else memo.getOrElseUpdate(i, i * factorialMemoized(i - 1))
    
    (0 to n).map(factorialMemoized).toList

/**
 * Computes the factorial sequence from 0! to n! using tail recursion for optimal performance.
 * 
 * This implementation uses an accumulator pattern to build the factorial sequence
 * iteratively in a tail-recursive manner, ensuring constant stack space usage.
 * The @tailrec annotation ensures the compiler optimizes this to a loop.
 * 
 * @param n the upper bound of the sequence (inclusive)
 * @param i the current index being processed (starts at 0)
 * @param acc the accumulator for the current factorial value (starts at 1 for 0!)
 * @param result the accumulated list of factorial values (starts empty)
 * @return a list containing [0!, 1!, 2!, ..., n!]
 * 
 * Example: factorialSequenceTailRecursive(4) should return [1, 1, 2, 6, 24]
 */
def factorialSequenceTailRecursive(n: Int, i: BigInt = 0, acc: BigInt = 1, result: List[BigInt] = Nil): List[BigInt] =
    if i > n then result
    else
        val proximoAcc = if i == 0 then acc else acc * i
        factorialSequenceTailRecursive(n, i + 1, proximoAcc, result :+ proximoAcc)

/**
 * Main entry point for testing the factorial sequence implementations.
 * 
 * This function can be used to test and compare the different implementations
 * of the factorial sequence computation.
 */
@main def mainFactorialSequence(): Unit = {
    // factorialSequenceNaive
    println(factorialSequenceNaive(5))

    // factorialSequenceMemoized
    val memo = mutable.Map[Int, BigInt]()
    println(factorialSequenceMemoized(5, memo))

    // factorialSequenceTailRecursive
    println(factorialSequenceTailRecursive(5))
}