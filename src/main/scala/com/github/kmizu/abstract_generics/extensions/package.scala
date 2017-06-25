package com.github.kmizu.abstract_generics

import com.github.kmizu.abstract_generics.type_classes.AMonoid
import scala.collection.TraversableLike

package object extensions {
  implicit class RichTraversable[B](self: Traversable[B]) {
    def asum(implicit amonoid: AMonoid { type A = B }): B = {
      self.foldLeft(amonoid.mzero)(amonoid.mplus)
    }
  }
}
