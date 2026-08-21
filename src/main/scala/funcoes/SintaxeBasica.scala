package funcoes

def sum(a: Int, b: Int): Int = a + b

def finalPrice(price: Double, isPremium: Boolean): Double =
    if price < 0 then 0.0
    else if isPremium then price * 0.8
    else price * 0.8
