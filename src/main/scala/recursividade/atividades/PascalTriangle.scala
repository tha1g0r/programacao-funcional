package recursividade.atividades

import scala.collection.mutable
import scala.annotation.tailrec

/**
 * Computes a single element of Pascal's Triangle using naive recursion.
 * 
 * Pascal's Triangle follows the rule: C(n,k) = C(n-1,k-1) + C(n-1,k)
 * with base cases: C(n,0) = 1 and C(n,n) = 1 for all n >= 0
 * 
 * This implementation uses direct recursion without optimization,
 * leading to exponential time complexity due to repeated calculations.
 * 
 * @param n the row number (0-indexed)
 * @param k the column number (0-indexed)
 * @return the value at position (n,k) in Pascal's Triangle
 * 
 * Example: pascalRecursive(4, 2) should return 6
 * Pascal's Triangle visualization:
 *     1
 *   1   1
 *  1  2  1
 * 1  3  3  1
 *1  4  6  4  1  <- row 4, position 2 = 6
 */
def pascalRecursive(n: Int, k: Int): BigInt =
    if k == 0 || n == k then 1
    else pascalRecursive(n - 1, k - 1) + pascalRecursive(n - 1, k)

/**
 * Computes a single element of Pascal's Triangle using memoization.
 * 
 * This implementation caches previously computed values in a mutable map
 * to avoid recalculating the same Pascal Triangle elements multiple times,
 * significantly improving performance for larger inputs.
 * 
 * @param n the row number (0-indexed)
 * @param k the column number (0-indexed)
 * @param memo a mutable map to cache computed values (key: (n,k), value: result)
 * @return the value at position (n,k) in Pascal's Triangle
 * 
 * Example: pascalMemoized(4, 2, mutable.Map()) should return 6
 */
def pascalMemoized(n: Int, k: Int, memo: mutable.Map[(Int, Int), BigInt]): BigInt =
    if k == 0 || n == k then 1
    else
        memo.getOrElseUpdate((n, k),
        pascalMemoized(n - 1, k - 1, memo) + pascalMemoized(n - 1, k, memo))

/**
 * Computes a single element of Pascal's Triangle using an iterative approach.
 * 
 * This implementation uses the mathematical formula for combinations:
 * C(n,k) = n! / (k! * (n-k)!)
 * 
 * However, it should be implemented iteratively to avoid computing large factorials
 * and potential overflow issues
 * 
 * @param n the row number (0-indexed)
 * @param k the column number (0-indexed)
 * @return the value at position (n,k) in Pascal's Triangle
 * 
 * Example: pascalTailRecursive(4, 2) should return 6
 */
def pascalTailRecursive(n: Int, k: Int): BigInt = ???

/**
 * Main entry point for testing the Pascal's Triangle implementations.
 * 
 * This function can be used to test and compare the different implementations
 * of Pascal's Triangle computation.
 */
@main def mainPascalTriangle(): Unit = {
    // pascalRecursive
    println(pascalRecursive(4, 1))
    println(pascalRecursive(4, 2))
    println(pascalRecursive(4, 1))

    // pascalMemoized
    val memo = mutable.Map[(Int, Int), BigInt]()
    println(pascalMemoized(4, 1, memo))
    println(pascalMemoized(4, 2, memo))
    println(pascalMemoized(4, 1, memo))
}