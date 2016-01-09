val x = new Rational(1, 3)

val y = new Rational(5, 7)

val z = new Rational(3, 2)

val result = x.sub(y).sub(z)

val t = new Rational(2)

class Rational(x: Int, y: Int) {
  def numer = x

  def denom = y

  def this(x: Int) = this(x, 1)

  def add(that: Rational) =
    new Rational(numer * that.denom + denom * that.numer, denom * that.denom)

  def neg() = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg())

  override def toString: String =
    if (denom != 1) numer + "/" + denom
    else numer.toString

}
