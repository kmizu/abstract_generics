package com.github.kmizu.abstract_generics

abstract class Cell extends TypeConstructor {self =>
  type T
  def head: self.T
  def tail: Cell { type T = self.T }
}

abstract class Cons extends Cell {self =>
  override type T
  def head: self.T
  def tail: Cell { type T = self.T }
  override def toString(): String = head + " :: " + tail
}

class Empty extends Cell {self =>
  override type T
  def head: self.T = throw new NoSuchMethodException("Empty.head")
  def tail: Cell { type T = self.T } = throw new NoSuchMethodException("Empty.tail")

  override def toString(): String = "Empty"
}
