import java.util.NoSuchElementException

abstract class Nat {
  def isZero: Boolean

  def predecessor: Nat

  def successor: Nat

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

class Zero extends Nat {
  override def isZero: Boolean = true

  override def successor: Nat = {
    new Succ(this)
  }

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = throw NoSuchMethodException

  override def predecessor: Nat = throw new NoSuchElementException
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = new Succ(successor + n.predecessor)

  override def -(that: Nat): Nat = {
    val x = try {predecessor - n.predecessor} catch {
      case e: NoSuchElementException => predecessor
    }
    x
  }

  override def predecessor: Nat = n
}


val three: Succ = new Succ(new Succ(new Succ(new Zero)))
val four: Succ = new Succ(new Succ(new Succ(new Succ(new Zero))))

