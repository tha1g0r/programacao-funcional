package scalabasico.atividade

/**
  * Calculates the real roots of a quadratic equation ax^2 + bx + c = 0.
  *
  * @param a Coefficient of x^2
  * @param b Coefficient of x
  * @param c Constant term
  * @return A list containing the real roots in ascending order. Returns an empty list if there are no real roots or if a == 0.
  */
def quadraticFunctionRoots(a: Double, b: Double, c: Double): List[Double] = {
    throw new NotImplementedError("Function not implemented yet")
}

/**
  * Computes the subtotal, delivery fee, and total for a delivery order based on product code and quantity.
  *
  * @param code Product code (1 to 6)
  * @param quantity Number of items ordered
  * @return A list with [subtotal, delivery fee, total]. Returns an empty list if the code is invalid or quantity is not positive.
  */
def deliveryBill(code: Int, quantity: Int): List[Double] = {
    throw new NotImplementedError("Function not implemented yet")
}

/**
  * Interleaves two integer lists with exactly three elements each.
  *
  * If l1 = List(a, b, c) and l2 = List(x, y, z), the result is List(a, x, b, y, c, z).
  * Returns an empty list if any input does not have exactly three elements.
  */
def interleaveLists(l1: List[Int], l2: List[Int]): List[Int] = {
    throw new NotImplementedError("Function not implemented yet")
}

/**
  * Computes the absolute difference in seconds between two times of the same day.
  *
  * Each time must be represented as List(hours, minutes, seconds).
  * Returns -1 if any time is invalid or if any list does not have exactly three elements.
  */
def timeDifference(t1: List[Int], t2: List[Int]): Int = {
    throw new NotImplementedError("Function not implemented yet")
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
    throw new NotImplementedError("Function not implemented yet")
}

@main def scalaBasico() = {
    // Example usage of the functions (use to perform manual testing)
}