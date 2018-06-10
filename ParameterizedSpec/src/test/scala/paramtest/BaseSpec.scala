package paramtest

import com.typesafe.config.ConfigFactory

import scala.util.Try

/**
  * Created by mogli on 8/31/17.
  */
object BaseSpecTest {

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()

    val ex = Try(config.getString("paramstest.excludes"))
    println("excludes is : " + excludeList(ex))
  }

  def excludeList(tryString : Try[String]) : List[Int] = {
    try {
      val strList = tryString.getOrElse("")
      val intList = strList.split(",") map { s => s.trim.toInt }
      intList.toList
    }catch{
      case ex : RuntimeException => List[Int]()
    }
  }
}