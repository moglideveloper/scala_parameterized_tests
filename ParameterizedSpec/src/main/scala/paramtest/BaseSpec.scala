package paramtest

import ptest.ParametrizedTest.bodyBuffer
import com.typesafe.config.ConfigFactory
import model.BodyArgument
import org.scalatest.FlatSpecLike
import ptest.ParametrizedTest

import scala.util.Try

/**
  * Created by mogli on 9/2/17.
  */
trait BaseSpec extends FlatSpecLike {

  final def executeTests(): Unit = {

    val (all, includesList) = includePlan()

    var counter = 0
    bodyBuffer foreach { body =>
      counter = counter + 1

      val isIncluded = includesList.contains(body.testIndex)

      if (all || isIncluded) {
        executeTestBody(body)
      }
    }
  }

  final def includePlan(): (Boolean, Set[Int]) = {
    val config = ConfigFactory.load
    val (all, includes) = includesList(Try(config.getString(s"paramtest.${getClass.getName}.includes")))
    (all, includes)
  }

  final def includesList(tryString: Try[String]): (Boolean, Set[Int]) = {
    try {
      val strList = tryString.getOrElse("")
      strList.trim.toUpperCase match {
        case "*" => (true, Set[Int]())
        case "" => (false, Set[Int]())
        case _ =>
          val intList = strList.split(",") map { s => s.trim.toInt }
          (false, intList.toSet)
      }

    } catch {
      case ex: RuntimeException => (true, Set[Int]())
    }
  }

  final def excludePlan(): Set[Int] = {
    val config = ConfigFactory.load
    val excludes = excludesList(Try(config.getString(s"${getClass.getName}.excludes")))
    excludes
  }

  final def excludesList(tryString: Try[String]): Set[Int] = {
    try {
      val strList = tryString.getOrElse("")
      val intList = strList.split(",") map { s => s.trim.toInt }
      intList.toSet
    } catch {
      case ex: RuntimeException => Set[Int]()
    }
  }

  def executeTestBody(body: BodyArgument): Unit = {

    body.msg.prefix should body.msg.suffix in {
      body()
    }
  }
}