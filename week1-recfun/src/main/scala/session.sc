def abs(x: Double) = if (x < 0) -x else x

def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)

def isGoodEnough(guess: Double, x: Double) =
  abs(guess * guess - x) < 0.001 * x

def improve(guess: Double, x: Double) =
  (guess + x / guess) / 2

def sqrt(x: Double) = sqrtIter(1.0, x)

sqrt(0.001)
sqrt(0.1e-20)
sqrt(1.0e20)
sqrt(1.0e50)


def factorial(m: Int): Int = {
  def factorialStep(acc: Int, n: Int): Int = {
    if (n == 0) acc
    else factorialStep(n * acc, n - 1)
  }

  factorialStep(1, m)
}
factorial(4)