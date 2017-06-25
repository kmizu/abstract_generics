package com.github.kmizu.abstract_generics

trait Function {
  type In
  type Out
  def apply(arg: In): Out
}
object Function {
  def id[I, O >: I <: I]: Function { type In = I; type Out = O} = new Function {
    type In = I
    type Out = O
    def apply(arg: In): Out = arg
  }

  def add: Function { type In = Int; type Out = Function{ type In = Int; type Out = Int}} = new Function {
    override type In = Int
    override type Out = Function { type In = Int; type Out = Int }
    override def apply(x: Int): Function { type In = Int; type Out = Int} = new Function {
      type In = Int
      type Out = Int
      override def apply(y: Int): Int = x + y
    }
  }
  def subtract: Function { type In = Int; type Out = Function{ type In = Int; type Out = Int}} = new Function {
    override type In = Int
    override type Out = Function { type In = Int; type Out = Int }
    override def apply(x: Int): Function { type In = Int; type Out = Int} = new Function {
      type In = Int
      type Out = Int
      override def apply(y: Int): Int = x - y
    }
  }
  def multiply: Function { type In = Int; type Out = Function{ type In = Int; type Out = Int}} = new Function {
    override type In = Int
    override type Out = Function { type In = Int; type Out = Int }
    override def apply(x: Int): Function { type In = Int; type Out = Int} = new Function {
      type In = Int
      type Out = Int
      override def apply(y: Int): Int = x * y
    }
  }
  def divide: Function { type In = Int; type Out = Function{ type In = Int; type Out = Int}} = new Function {
    override type In = Int
    override type Out = Function { type In = Int; type Out = Int }
    override def apply(x: Int): Function { type In = Int; type Out = Int} = new Function {
      type In = Int
      type Out = Int
      override def apply(y: Int): Int = x / y
    }
  }
}
