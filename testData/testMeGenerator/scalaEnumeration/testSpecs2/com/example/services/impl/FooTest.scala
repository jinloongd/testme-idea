package com.example.services.impl

import org.specs2.mutable.Specification

/** created by TestMe integration test on MMXVI */
class FooTest extends Specification {
  val foo = new Foo(com.example.scala.WeekDay.Mon)

  "Foo" should {

    "beam Me Up" in {
      val result = foo.beamMeUp(com.example.scala.Planet.G, com.example.scala.WeekDay.Mon, Some(com.example.scala.WeekDay.Mon))
      result === "replaceMeWithExpectedResult"
    }

  }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme