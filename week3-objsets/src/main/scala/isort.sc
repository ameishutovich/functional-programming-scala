object Isorts {
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys =>if (y > x) x :: xs
    else y :: insert(x, ys)
  }

  def capitalize(s: String) = {
    s.split(" ").map(x => x.toLowerCase.capitalize).mkString(" ")
  }
}

Isorts.isort(List(1, -1, -2, 43, 2, 45))

Isorts.capitalize("mAmle eLjeLL lLkeKKK Ker")