package com.github.kmizu.abstract_generics.type_classes

trait AShow {
  type T
  def show(t: T): String
}

object AShow {
  implicit val IntAShow: AShow { type T = Int } = new AShow {
    override type T = Int
    override def show(t: T): String = t.toString
  }
  implicit val LongAShow: AShow { type T = Long } = new AShow {
    override type T = Long
    override def show(t: T): String = t.toString
  }
  implicit val FloatAShow: AShow { type T = Float } = new AShow {
    override type T = Float
    override def show(t: T): String = t.toString
  }
  implicit val DoubleAShow: AShow { type T = Double } = new AShow {
    override type T = Double
    override def show(t: T): String = t.toString
  }
  implicit val BooleanAShow: AShow { type T = Boolean } = new AShow {
    override type T = Boolean
    override def show(t: T): String = t.toString
  }
  implicit def ListAShow[A](implicit ashow: AShow { type T = A }): AShow { type T = List[A] } = new AShow {
    override type T = List[A]
    override def show(t: T): String = t.map(ashow.show(_)).mkString(", ")
  }
  implicit val StringAShow: AShow { type T = Int } = new AShow {
    override type T = Int
    override def show(t: T): String = t.toString
  }
}
