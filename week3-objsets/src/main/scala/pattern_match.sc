trait Expr

case class Var(v: String) extends Expr

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Prod(e1: Expr, e2: Expr) extends Expr

object Exprs {
  def show(e: Expr): String = e match {
    case Var(v) => v
    case Number(n) => n.toString
    case Sum(l, r) => show(l) + " + " + show(r)
    case Prod(x, y) => p(x) + " * " + p(y)
  }

  def p(e: Expr): String = e match {
    case Sum(l1, r2) => "(" + show(e) + ")"
    case _ => show(e)
  }
}

Exprs.show(Sum(Prod(Number(2), Var("x")), Var("y")))
Exprs.show(Prod(Sum(Number(2), Var("x")), Var("y")))