package testdata

import scala.util.Random

/**
  * Created by vermri5 on 8/27/17.
  */
trait BasicTestData {
  def getEven(input : Unit): Int = {
    Random.nextInt(45) * 2
  }

  def getOdd(input : Unit): Int = {
    getEven(input) + 1
  }

  def number(s : String) : Int = s.toInt

  def sumOfTwoNumbers(x : Int, y : Int) : Int = x + y

  def oneToTwo(input : Unit): (Int, Int) = {
    val r = 100 + Random.nextInt(100)
    val params = (r / 2, r / 3)
    params
  }

  def openOptional(a : Option[Int] = None, b : Option[String] = None, c : Option[Double] = None) : Int = {

    val va = a.fold(0)(identity)
    val vb = b.fold(1)(_.toInt)
    val vc = c.fold(2)(_.toInt)
    (va + vb + vc)
  }

  case class Config(a : Option[Int] = None, b : Option[String] = None, c : Option[Double] = None)

  def packedOptional(config : Config) : Int = {

    import config._

    val va = a.fold(0)(identity)
    val vb = b.fold(1)(_.toInt)
    val vc = c.fold(2)(_.toInt)
    (va + vb + vc)
  }

  def toOption(i : Int): Option[Int] = Option(i)
}