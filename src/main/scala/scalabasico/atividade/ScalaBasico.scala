package scalabasico.atividade

import scala.annotation.tailrec

/**
  * Calculates the real roots of a quadratic equation ax^2 + bx + c = 0.
  *
  * @param a Coefficient of x^2
  * @param b Coefficient of x
  * @param c Constant term
  * @return A list containing the real roots in ascending order. Returns an empty list if there are no real roots or if a == 0.
  */
def quadraticFunctionRoots(a: Double, b: Double, c: Double): List[Double] = {
    val delta = (b * b) - (4 * a * c)

    if a == 0 || delta < 0 then List()
    else if delta == 0 then List((-b) / (2 * a))
    else
        val x1 = ((-b) - Math.sqrt(delta)) / (2 * a)
        val x2 = ((-b) + Math.sqrt(delta)) / (2 * a)
        List(x1, x2)
}

/**
  * Computes the subtotal, delivery fee, and total for a delivery order based on product code and quantity.
  *
  * @param code Product code (1 to 6)
  * @param quantity Number of items ordered
  * @return A list with [subtotal, delivery fee, total]. Returns an empty list if the code is invalid or quantity is not positive.
  */
def deliveryBill(code: Int, quantity: Int): List[Double] = {
    val nProdutos = 6
    if code <= 0 || code > nProdutos || quantity <= 0 then List()
    else
        val precoPadrao = code match
            case 1 => 8.0
            case 2 => 13.5
            case 3 => 15.0
            case 4 => 17.5
            case 5 => 5.5
            case 6 => 5
        
        val pesoPadrao = code match
            case 1 => 150
            case 2 => 240
            case 3 => 280
            case 4 => 300
            case 5 => 50
            case 6 => 330
        
        val subTotal = precoPadrao * quantity
        val pesoFinal = pesoPadrao * quantity

        val taxaEntrega = if pesoFinal > 1000 then 8 else 4

        val total = subTotal + taxaEntrega

        List(subTotal, taxaEntrega, total)
}

/**
  * Interleaves two integer lists with exactly three elements each.
  *
  * If l1 = List(a, b, c) and l2 = List(x, y, z), the result is List(a, x, b, y, c, z).
  * Returns an empty list if any input does not have exactly three elements.
  */
def interleaveLists(l1: List[Int], l2: List[Int]): List[Int] = {
    @tailrec
    def interLeaveRec(l1: List[Int], l2: List[Int], acc: List[Int] = List()): List[Int] =
        if acc.size == 6 then acc.reverse
        else interLeaveRec(l1.tail, l2.tail, l2.head :: l1.head :: acc)

    if l1.size != 3 || l2.size != 3 then List()
    else interLeaveRec(l1, l2)
}

/**
  * Computes the absolute difference in seconds between two times of the same day.
  *
  * Each time must be represented as List(hours, minutes, seconds).
  * Returns -1 if any time is invalid or if any list does not have exactly three elements.
  */
def timeDifference(t1: List[Int], t2: List[Int]): Int = {
    def convertToSeconds(t: List[Int]): Int =
        val h = t(0)
        val m = t(1)
        val s = t(2)
        s + m * 60 + h * 60 * 60

    def validTime(t: List[Int]): Boolean = t match
        case List(h, m, s) => h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59
        case _ => false
    
    if !validTime(t1) || !validTime(t2) then -1
    else
        val s1 = convertToSeconds(t1)
        val s2 = convertToSeconds(t2)
        Math.abs(s1 - s2)
}

/**
  * Determines whether a given day, month, and year form a valid date in the Gregorian calendar.
  *
  * @param day Day of month
  * @param month Month of year
  * @param year Year value
  * @return True when the date is valid, false otherwise
  */
def validateDate(day: Int, month: Int, year: Int): Boolean = {
    val maskGeral = month >= 1 && month <= 12 && day >= 1
    val maskAnoBissexto = (year % 400 == 0) || ((year % 4 == 0) && !(year % 100 == 0))
    val meses31Dias = List(1, 3, 5, 7, 8, 10, 12)
    val meses30Dias = List(4, 6, 9, 11)

    month >= 1 && month <= 12 && day >= 1 && (
        if meses30Dias.contains(month) then day <= 30
        else if meses31Dias.contains(month) then day <= 31
        else
            if maskAnoBissexto then day <= 29
            else day <= 28
    )
}

@main def scalaBasico() = {
    // Example usage of the functions (use to perform manual testing)
    println("Testando quadraticFunctionRoots:")
    println(s"${quadraticFunctionRoots(1.2, -34.5, 5.8)}") // List(0.169, 28.581)
    println(s"${quadraticFunctionRoots(1, 0, 0)}") // List(0.0)
    println(s"${quadraticFunctionRoots(1, 2, 3)}") // List()

    // ---
    println("\nTestando deliveryBill:")
    println(s"${deliveryBill(1, 1)}") // List(8.0, 4.0, 12.0)
    println(s"${deliveryBill(2, 5)}") // List(67.5, 8.0, 75.5)
    println(s"${deliveryBill(1, 0)}") // List()

    // ---
    println("\nTestando interleaveLists:")
    println(s"${interleaveLists(List(1, 2, 3), List(10, 20, 30))}") // List(1, 10, 2, 20, 3, 30)
    println(s"${interleaveLists(List(-1, 0, 1), List(5, 6, 7))}") // List(-1, 5, 0, 6, 1, 7)

    // ---
    println("\nTestando timeDifference:")
    println(s"${timeDifference(List(10, 15, 30), List(10, 15, 30))}") // 0
    println(s"${timeDifference(List(10, 0, 0), List(11, 30, 0))}") // 5400
    println(s"${timeDifference(List(23, 59, 59), List(23, 59, 0))}") // 59
    println(s"${timeDifference(List(24, 0, 0), List(10, 0, 0))}") // -1

    // ---
    println("\nTestando validateDate:")
    println(s"${{validateDate(15, 8, 2024)}}") // true
    println(s"${{validateDate(29, 2, 2024)}}") // true
    println(s"${{validateDate(29, 2, 2023)}}") // false
    println(s"${{validateDate(31, 4, 2024)}}") // false
}