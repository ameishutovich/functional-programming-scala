def isPrime(n: Int): Boolean = 2 until n forall (n % _ != 0)

isPrime(10)
isPrime(8)
isPrime(5)
isPrime(3)
isPrime(2)
isPrime(1)



def scalarProduct(xs: List[Double], ys: List[Double]): Double =
  (for {(x, y) <- xs zip ys} yield x * y) sum

scalarProduct(List(1, 2), List(4, 5))



val n = 4
def isSafe(col: Int, queens: List[Int]): Boolean = {
  val row = queens.length
  val qs = (row - 1 to 0 by -1) zip queens

  val leftDiag = (row to 0 by -1) zip (col to 0 by -1)
  val rightDiag = (row to 0 by -1) zip (col to n)
  val diagCheck = (leftDiag ++ rightDiag) forall (!qs.contains(_))

  diagCheck && !queens.contains(col)
}

isSafe(0, List(0, 3, 1))
isSafe(1, List(0, 3, 1))
isSafe(2, List(0, 3, 1))
isSafe(3, List(0, 3, 1))


//def books = 
//
//for(b <- books; a <- b.authors if a startsWith "Bird") yeild b.title
//
//books.flatMap(b => b.authors.withFilter(a => a startsWith "Bird").map(_ => b.title))

class Poly(terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)

  val terms = terms0 withDefaultValue 0.0

  def +(other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (power, koeff) = term
    val item = (power, terms(power) + koeff)
    terms + item
  }

  override def toString: String = (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}

val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
val p2 = new Poly(0 -> 3.0, 3 -> 7.0)

p1 + p2