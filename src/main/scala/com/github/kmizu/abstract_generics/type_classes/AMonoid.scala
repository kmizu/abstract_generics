package com.github.kmizu.abstract_generics.type_classes

trait AMonoid {
  type A
  def mplus(x: A, y: A): A
  def mzero: A
}

object AMonoid {
  implicit val IntAMonoid: AMonoid { type A = Int } = new AMonoid {
    override type A = Int
    override def mplus(x: A, y: A): A = x + y
    override def mzero: A = 0
  }
  implicit val LongAMonoid: AMonoid { type A = Long } = new AMonoid {
    override type A = Long
    override def mplus(x: A, y: A): A = x + y
    override def mzero: A = 0L
  }
  implicit val FloatAMonoid: AMonoid { type A = Float } = new AMonoid {
    override type A = Float
    override def mplus(x: A, y: A): A = x + y
    override def mzero: A = 1.0F
  }
  implicit val DoubleAMonoid: AMonoid { type A = Double } = new AMonoid {
    override type A = Double
    override def mplus(x: A, y: A): A = x + y
    override def mzero: A = 1.0
  }
  implicit val BooleanAMonoid: AMonoid { type A = Boolean } = new AMonoid {
    override type A = Boolean
    override def mplus(x: A, y: A): A = x | y
    override def mzero: A = false
  }
  // Another version of AMonoid { type A = Boolean }
  val BooleanAMonoidOpt: AMonoid { type A = Boolean } = new AMonoid {
    override type A = Boolean
    override def mplus(x: A, y: A): A = x & y
    override def mzero: A = true
  }

  implicit def ListAMonoid[T]: AMonoid { type A = List[T] } = new AMonoid {
    override type A = List[T]
    override def mzero: A = Nil
    override def mplus(x: A, y: A): A = x ::: y
  }
}
