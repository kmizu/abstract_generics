package com.github.kmizu.abstract_generics

import org.scalatest.{DiagrammedAssertions, FlatSpec, FunSpec}

class CompositionSpec extends FunSpec with DiagrammedAssertions {
  describe("Composition") {
    it("of (x => x * 2) and (x => x + 2)") {
      val result = Composition.function(Function.multiply(2), Function.add(2))
      assert(result(2) == 8)
    }
    it("of (x => x + 2) and (x => x * 2)") {
      val result = Composition.function(Function.add(2), Function.multiply(2))
      assert(result(2) == 6)
    }
  }
  describe("AndThen") {
    it("of (x => x * 2) and (x => x + 2)") {
      val result = AndThen.function(Function.multiply(2), Function.add(2))
      assert(result(2) == 6)
    }
    it("of (x => x + 2) and (x => x * 2)") {
      val result = AndThen.function(Function.add(2), Function.multiply(2))
      assert(result(2) == 8)
    }
  }
}
