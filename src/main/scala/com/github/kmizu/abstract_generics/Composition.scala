package com.github.kmizu.abstract_generics

abstract class Composition extends Function {self =>
  type Middle
  type In
  type Out
  def f: Function { type In = self.Middle; type Out = self.Out }
  def g: Function { type In = self.In; type Out = self.Middle }
  def apply(in: In): Out = {
    f(g(in))
  }
}
object Composition {
  def function[A, B, C](
    pf: Function { type In = B; type Out = C},
    pg: Function { type In = A; type Out = B}
  ): Function { type In = A; type Out = C} = {
    new Composition {
      type Middle = B
      type In = A
      type Out = C
      def f = pf
      def g = pg
    }
  }
}
