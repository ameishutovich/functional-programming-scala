package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceStep(opened: Int, closed: Int, curChars: List[Char]): Boolean = {
      if (opened < closed) false
      else if (curChars.isEmpty) true
      else deeper(opened, closed, curChars)
    }

    def deeper(opened: Int, closed: Int, curChars: List[Char]): Boolean = {
      val head: Char = curChars.head
      if (head == '(') balanceStep(opened + 1, closed, curChars.tail)
      else if (head == ')') balanceStep(opened, closed + 1, curChars.tail)
      else balanceStep(opened, closed, curChars.tail)
    }

    balanceStep(0, 0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def iteration(solutions: List[(Int, List[Int])]): Int = {
      if (solutions.isEmpty) 0
      else {
        val (money, history) = solutions.head
        if (money < 0 || (money == 0 && history.isEmpty)) iteration(solutions.tail)
        else if (money == 0 && history.nonEmpty) 1 + iteration(solutions.tail)
        else {
          val list = changeOneCoin(money, coins, history)
          iteration(list) + iteration(solutions.tail)
        }
      }
    }

    def changeOneCoin(amount: Int, cs: List[Int], history: List[Int]): List[(Int, List[Int])] = {
      if (cs.isEmpty) Nil
      else if (history.isEmpty || cs.head >= history.head) {
        (amount - cs.head, cs.head :: history) :: changeOneCoin(amount, cs.tail, history)
      } else changeOneCoin(amount, cs.tail, history)
    }

    iteration(List((money, List())))
  }
}
