import java.util.NoSuchElementException

trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}

class Cons[T](val elem: T, val rest: List[T]) extends List[T] {
  override def isEmpty: Boolean = false

  override def tail: List[T] = rest

  override def head: T = elem
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true

  override def tail: List[T] = throw new NoSuchElementException("Nil.tail")

  override def head: T = throw new NoSuchElementException("Nil.head")
}
