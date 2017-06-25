package com.github.kmizu.abstract_generics

import org.scalatest.{DiagrammedAssertions, FunSpec}
import extensions._

class TraversableExtensionsSpec extends FunSpec with DiagrammedAssertions {
  describe("TraversableLike#asum") {
    it("List(1, 2, 3, 4, 5)") {
      assert(15 == List(1, 2, 3, 4, 5).asum)
    }
    it("List(List(1), List(2), List(3))") {
      assert(List(1, 2, 3) == List(List(1), List(2), List(3)).asum)
    }
  }
}
