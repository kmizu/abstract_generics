package com.github.kmizu.abstract_generics

abstract class AndThen extends Function {self =>
  type Middle
  type In
  type Out
  def f: Function { type In = self.In; type Out = self.Middle }
  def g: Function { type In = self.Middle; type Out = self.Out }
  def apply(in: In): Out = {
    g(f(in))
  }
}

object AndThen {
  def function [A, B, C](
    pf: Function { type In = A; type Out = B},
    pg: Function { type In = B; type Out = C}
  ): Function { type In = A; type Out = C} = {
    new AndThen {
      type In = A
      type Out = C
      type Middle = B
      def f = pf
      def g = pg
    }
  }
}