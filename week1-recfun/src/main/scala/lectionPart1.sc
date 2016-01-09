def operation(f: Int => Int)(g: (Int, Int) => Int)(a: Int, b: Int, acc: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, g(acc, f(a)))
  }
  loop(a, acc)
}

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  operation(f)((x, y) => x + y)(a, b, 0)
}

sum(z => z + 2)(1, 2)

def product(f: Int => Int)(a: Int, b: Int): Int = {
  operation(f)((x, y) => x * y)(a, b, 1)
}

product(z => z * z)(1, 3)

def factorial(n: Int): Int = {
  product(x => x)(1, n)
}

factorial(4)