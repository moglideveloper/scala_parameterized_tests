package paramtest

import ptest.ParametrizedTest.bodyBuffer
import com.typesafe.config.ConfigFactory
import model.BodyArgument
import org.scalatest.FlatSpecLike

import scala.util.Try

/**
  * Created by mogli on 9/2/17.
  */
trait BaseSpec extends FlatSpecLike {

  final def executeTests(): Unit = {

    val excludes = checkPlan()

    var counter = 0
    bodyBuffer foreach { body =>
      counter = counter + 1

      val isExcluded = excludes.contains(body.testIndex)

      if (!isExcluded) {
        executeTestBody(body)
      }
    }
  }

  final def checkPlan(): Set[Int] = {
    val config = ConfigFactory.load
    val excludes = excludesList(Try(config.getString("paramtest.excludes")))
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