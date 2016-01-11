object nth {
  def nth[T](n: Int, list: List[T]): T = {
    def nthStep(n: Int, list: List[T]): T = {
      if (n < 0 || list.isEmpty) throw new IndexOutOfBoundsException
      else if (n == 0) list.head
      else nthStep(n - 1, list.tail)
    }
    nthStep(n, list)
  }
}