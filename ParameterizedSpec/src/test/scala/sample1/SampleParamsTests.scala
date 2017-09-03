package sample1

import paramtest._
import org.scalatest.Matchers._
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach}


/**
  * Created by mogli on 8/29/17.
  */
class SampleParamsTests extends BaseSpec with BeforeAndAfterEach with BeforeAndAfterAll {

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    println("before each")
  }

  override protected def afterEach(): Unit = {
    super.afterEach()
    println("after each")
  }

  override protected def beforeAll(): Unit = {
    super.beforeAll()
    println("before all")
  }

  override protected def afterAll(): Unit = {
    super.afterAll()
    println("after all")
  }

  def x(s: String): Int = s.toInt

  def displayx(i: Int): Unit = println(i)

  (1, "a" will "pass").withNoƒ { case () =>
    println("blah blah")
  }

  (2, "b" will "pass").with1ƒ(x _, "3") { case (a) =>
    println(s"a is $a")
  }

  (3, "c" will "pass").with2ƒ(x _, "3")(x _, "3") { case (a, b) =>
    a should be(b)
  }

  executeTests()
}